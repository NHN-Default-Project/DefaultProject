package com.nhnacademy.Jminsoo.exercise7;

import com.nhnacademy.Jminsoo.exercise7.textio.TextIO;

/**
 * 사용자가 입력한 표준 표현식을 읽는 프로그램입니다.
 * 프로그램은 표현식을 나타내기 위한 표현식 트리를 만듭니다.
 * 그런 다음 트리의 값을 출력합니다. 또한 표현식을 평가하는 데 사용할 수 있는 명령 목록을 출력하는 데 사용합니다.
 * 표현식에는 양수 실수 및 이진 연산자 +, -, *, 및 /를 사용할 수 있으며 단항 마이너스 연산도 지원합니다. 표현식은 BNF 규칙에 의해 정의됩니다:
 *
 * <expression>  ::=  [ "-" ] <term> [ [ "+" | "-" ] <term> ]...
 *
 * <term>  ::=  <factor> [ [ "*" | "/" ] <factor> ]...
 *
 * <factor>  ::=  <number>  |  "(" <expression> ")"
 * <p>
 * 숫자는 숫자로 시작해야 합니다 (소수점 아님).
 * 입력 라인은 정확히 이러한 표현식 하나를 포함해야 합니다. 표현식을 읽은 후에 라인에 추가 데이터가 있는 경우 오류로 처리됩니다.
 * <p>
 * 메인 프로그램 클래스 SimpleParser3 외에도 이 프로그램은 표현식 트리를 구현하기 위한 네 개의 중첩 클래스를 정의합니다.
 */

public class SimpleParser3 {


    // -------------------- 표현식 트리를 위한 중첩 클래스 ------------------------------

    /**
     * 표현식 트리의 어떤 노드를 나타내는 추상 클래스입니다.
     * 세 개의 구체적인 노드 클래스가 구체적인 하위 클래스입니다.
     * 두 개의 인스턴스 메서드가 지정되어 있으므로, 이러한 메서드를 모든 ExpNode과 함께 사용할 수 있습니다.
     * value() 메서드는 표현식의 값을 반환하고, printStackCommands() 메서드는 표현식을 스택 머신에서 평가하기 위해 사용될 수 있는 명령 목록을 출력합니다.
     */

    /**
     * 상수의 도함수는 0입니다.
     * x의 도함수는 1입니다.
     * A가 표현식이라면, dA를 A의 도함수로 정의하면, -A의 도함수는 -dA입니다.
     * A와 B가 표현식이라면, dA를 A의 도함수로 정의하고, dB를 B의 도함수로 정의하면, A+B의 도함수는 dA+dB입니다.
     * A-B의 도함수는 dA-dB입니다.
     * AB의 도함수는 AdB + B*dA입니다.
     * A/B의 도함수는 (BdA - AdB) / (B*B)입니다.
     */
    private abstract static class ExpNode {

        abstract double value(double xValue);

        abstract void printStackCommands();

        abstract ExpNode derivative();

        abstract void printInfix();

    }

    /**
     * 추가된 클래스
     * x를 의미하는 표현식
     */

    private static class VariableNode extends ExpNode {
        double variableX;

        VariableNode(double variableX) {
            this.variableX = variableX;
        }

        @Override
        double value(double xValue) {
            return this.variableX;
        }

        @Override
        void printStackCommands() {
            System.out.println("  Push " + "x");
        }

        @Override
        void printInfix() {
            System.out.print("x");
        }

        @Override
        ExpNode derivative() {
            return new ConstNode(1.0);
        }


    }

    /**
     * 숫자를 보유하는 표현식 노드를 나타냅니다.
     */
    private static class ConstNode extends ExpNode {
        double number;  // 숫자.

        ConstNode(double val) {
            // 지정된 숫자를 포함하는 ConstNode를 구성합니다.
            number = val;
        }

        @Override
        double value(double xValue) {
            // 노드의 값은 그 안에 포함된 숫자입니다.
            return this.number;
        }


        @Override
        void printStackCommands() {
            // 스택 머신에서는 숫자를 스택에 넣습니다.
            System.out.println("  Push " + this.number);
        }

        @Override
        void printInfix() {
            System.out.print(this.number);
        }

        @Override
        ExpNode derivative() {
            return new ConstNode(0);
        }
    }

    /**
     * 이항 연산자를 나타내는 표현식 노드입니다.
     */
    private static class BinOpNode extends ExpNode {
        char op;        // 연산자.
        ExpNode left;   // 왼쪽 피연산자의 표현식.
        ExpNode right;  // 오른쪽 피연산자의 표현식.

        BinOpNode(char op, ExpNode left, ExpNode right) {
            // 지정된 데이터를 포함하는 BinOpNode를 구성합니다.
            assert op == '+' || op == '-' || op == '*' || op == '/';
            assert left != null && right != null;
            this.op = op;
            this.left = left;
            this.right = right;
        }

        @Override
        double value(double xValue) {
            // 값은 왼쪽 및 오른쪽 피연산자를 평가하고 연산자를 사용하여 값들을 결합하여 얻습니다.
            double leftValue = this.left.value(xValue);
            double rightValue = this.right.value(xValue);

            switch (op) {
                case '+':
                    return leftValue + rightValue;
                case '-':
                    return leftValue - rightValue;
                case '*':
                    return leftValue * rightValue;
                case '/':
                    return leftValue / rightValue;
                default:
                    return Double.NaN;  // 잘못된 연산자!
            }
        }

        void printStackCommands() {
            // 스택 머신에서 표현식을 평가하려면 먼저 왼쪽 피연산자를 평가하고 답을 스택에 남겨야 합니다.
            // 그런 다음 동일한 작업을 두 번째 피연산자에 대해 수행합니다.
            // 그런 다음 연산자를 적용합니다 (즉, 피연산자를 팝하고 연산자를 적용한 다음 결과를 푸시합니다).
            this.left.printStackCommands();
            this.right.printStackCommands();
            System.out.println("  Operator " + op);
        }

        @Override
        void printInfix() {
            System.out.print("(");
            this.left.printInfix();
            System.out.printf(" %c ", op);
            this.right.printInfix();
            System.out.print(")");
        }

        @Override
        ExpNode derivative() {
            ExpNode leftNode = this.left;
            ExpNode rightNode = this.right;
            switch (op) {
                case '+':
                    return new BinOpNode('+', leftNode.derivative(), rightNode.derivative());
                case '-':
                    return new BinOpNode('-', leftNode.derivative(), rightNode.derivative());
                case '*':
                    return new BinOpNode('+'
                            , new BinOpNode('*', leftNode, rightNode.derivative())
                            , new BinOpNode('*', rightNode, leftNode.derivative()));
                case '/':
                    return new BinOpNode('/'
                            , new BinOpNode('-'
                            , new BinOpNode('*', rightNode, leftNode.derivative())
                            , new BinOpNode('*', leftNode, rightNode.derivative()))
                            , new BinOpNode('*', rightNode, rightNode));
                default:
                    return null;
            }

        }
    }

    /**
     * 단항 마이너스 연산자를 나타내는 표현식 노드입니다.
     */
    private static class UnaryMinusNode extends ExpNode {
        ExpNode operand;  // 마이너스 연산이 적용되는 피연산자.

        UnaryMinusNode(ExpNode operand) {
            // 지정된 피연산자를 가지고 UnaryMinusNode를 구성합니다.
            assert operand != null;
            this.operand = operand;
        }

        @Override
        double value(double xValue) {
            // 값은 피연산자의 값의 부정입니다.
            return -xValue;
        }

        @Override
        void printStackCommands() {
            // 이 표현식을 스택 머신에서 평가하려면 먼저 피연산자를 평가하고 피연산자를 스택에 남겨야 합니다.
            // 그런 다음 단항 마이너스를 적용해야 합니다 (즉, 피연산자를 팝하고 반대로 하여 결과를 푸시해야 합니다).
            operand.printStackCommands();
            System.out.println("  Unary minus");
        }

        @Override
        ExpNode derivative() {
            return new BinOpNode('*', new ConstNode(-1), operand);
        }

        @Override
        void printInfix() {
            System.out.print("-");
            System.out.print("(");
            operand.printInfix();
            System.out.print(")");
        }
    }

    // -------------------------------------------------------------------------------

    /**
     * ParseError 형식의 객체는 사용자의 입력에서 발견된 구문 오류를 나타냅니다.
     */
    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // 중첩 클래스 ParseError의 끝

    private static boolean isDigit(String str) {
        if (str.isEmpty()) {
            return false;
        }

        for (char chr : str.toCharArray()) {
            if (!Character.isDigit(chr)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        double variableX;
        while (true) {
            System.out.print("\n\nx의 값을 입력하시오 : ");
            String inputStr = TextIO.getln();

            if (!isDigit(inputStr)) {
                System.out.println("실수형태로만 입력해주세요!");
                continue;
            } else {
                variableX = Double.parseDouble(inputStr);
            }

            System.out.println("\n\n표현식을 입력하거나 반환 키를 눌러 종료합니다.");
            System.out.print("\n?  ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n')
                break;
            try {
                ExpNode exp = expressionTree(variableX);
                TextIO.skipBlanks();
                if (TextIO.peek() != '\n')
                    throw new ParseError("표현식 종료 후 추가 데이터가 있습니다.");
                TextIO.getln();
                ExpNode derivExp = exp.derivative();
                System.out.println("\n값: " + derivExp.value(variableX));
                System.out.println("\n괄호 표현식:\n");
                derivExp.printInfix();
                System.out.println("\n후위 표현식:\n");
                derivExp.printStackCommands();
            } catch (ParseError e) {
                System.out.println("\n*** 입력 오류: " + e.getMessage());
                System.out.println("*** 입력을 삭제합니다: " + TextIO.getln());
            }
        }

        System.out.println("\n\n완료.");
    } // main() 메서드의 끝


    /**
     * 현재 입력 라인에서 표현식을 읽고 표현식을 나타내는 표현식 트리를 작성합니다.
     *
     * @return 표현식 트리의 루트 노드를 가리키는 ExpNode입니다.
     * @throws ParseError 입력에서 구문 오류가 발견되면
     */
    private static ExpNode expressionTree(double variableX) throws ParseError {
        TextIO.skipBlanks();
        boolean negative;  // 음수 부호가 있는 경우 true입니다.
        negative = false;
        if (TextIO.peek() == '-') {
            TextIO.getAnyChar();
            negative = true;
        }
        ExpNode exp;       // 표현식에 대한 표현식 트리.
        exp = termTree(variableX);  // 첫 번째 항으로 시작합니다.
        if (negative)
            exp = new UnaryMinusNode(exp);
        TextIO.skipBlanks();
        while (TextIO.peek() == '+' || TextIO.peek() == '-') {
            // 다음 항을 읽고 이전 항과 결합하여 더 큰 표현식 트리를 만듭니다.
            char op = TextIO.getAnyChar();
            ExpNode nextTerm = termTree(variableX);
            exp = new BinOpNode(op, exp, nextTerm);
            TextIO.skipBlanks();
        }
        return exp;
    } // expressionTree() 메서드의 끝


    /**
     * 현재 입력 라인에서 항을 읽고 항을 나타내는 표현식 트리를 작성합니다.
     *
     * @return 항을 나타내는 표현식 트리의 루트 노드를 가리키는 ExpNode입니다.
     * @throws ParseError 입력에서 구문 오류가 발견되면
     */
    private static ExpNode termTree(double variableX) throws ParseError {
        TextIO.skipBlanks();
        ExpNode term;  // 항을 나타내는 표현식 트리.
        term = factorTree(variableX);
        TextIO.skipBlanks();
        while (TextIO.peek() == '*' || TextIO.peek() == '/') {
            // 다음 인수를 읽고 이전 인수와 결합하여 더 큰 표현식 트리를 만듭니다.
            char op = TextIO.getAnyChar();
            ExpNode nextFactor = factorTree(variableX);
            term = new BinOpNode(op, term, nextFactor);
            TextIO.skipBlanks();
        }
        return term;
    } // termValue() 메서드의 끝

    /**
     * 현재 입력 라인에서 인수를 읽고 인수를 나타내는 표현식 트리를 작성합니다.
     *
     * @return 인수를 나타내는 표현식 트리의 루트 노드를 가리키는 ExpNode입니다.
     * @throws ParseError 입력에서 구문 오류가 발견되면
     */
    private static ExpNode factorTree(double variableX) throws ParseError {
        TextIO.skipBlanks();
        char ch = TextIO.peek();
        if (Character.isDigit(ch)) {
            // 인수는 숫자입니다. ConstNode를 반환합니다.
            double num = TextIO.getDouble();
            return new ConstNode(num);
        } else if (ch == '(') {
            // 인수는 괄호 안에 있는 표현식입니다.
            // 해당 표현식을 나타내는 트리를 반환합니다.
            TextIO.getAnyChar();  // "("를 읽습니다.
            ExpNode exp = expressionTree(variableX);
            TextIO.skipBlanks();
            if (TextIO.peek() != ')')
                throw new ParseError("오른쪽 괄호가 누락되었습니다.");
            TextIO.getAnyChar();  // ")"를 읽습니다.
            return exp;
        } else if (ch == 'x' || ch == 'X') {
            TextIO.getAnyChar();
            return new VariableNode(variableX);
        } else if (ch == '\n')
            throw new ParseError("표현식 중간에 개행 문자가 있습니다.");
        else if (ch == ')')
            throw new ParseError("추가 오른쪽 괄호가 있습니다.");
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            throw new ParseError("잘못된 연산자입니다.");
        } else {
            throw new ParseError("예상치 못한 문자 \"" + ch + "\"가 있습니다.");
        }
    } // factorTree() 메서드의 끝
} // SimpleParser3 클래스의 끝
