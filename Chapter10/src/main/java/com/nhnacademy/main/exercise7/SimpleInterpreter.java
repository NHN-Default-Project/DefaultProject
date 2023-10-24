package com.nhnacademy.main.exercise7;

/**
 * 이 프로그램은 숫자, 변수, 괄호 및 연산자 +, -, *, /, ^ (거듭 제곱을 나타냄)를 포함하는 표현식을 계산할 수 있습니다.
 * 변수 이름은 문자와 숫자로 구성되어야 하며 문자로 시작해야 합니다. 이름은 대소문자를 구분합니다.
 * 이 프로그램은 사용자로부터 두 가지 유형의 명령을 받습니다.
 * "print <expression>" 형식의 명령의 경우 표현식이 계산되고 값이 출력됩니다.
 * "let <variable> = <expression>" 형식의 명령의 경우 표현식이 계산되고 해당 값을 변수에 할당합니다.
 * 변수에 값이 할당되기 전에 표현식에서 변수를 사용하면 오류가 발생합니다. 숫자는 숫자로 시작해야 합니다 (소수점이 아님).
 * <p>
 * 명령은 공식적으로 다음 BNF 규칙으로 정의됩니다:
 *
 * <command>  ::=  "print" <expression>
 * |  "let" <variable> "=" <expression>
 *
 * <expression>  ::=  [ "-" ] <term> [ [ "+" | "-" ] <term> ]...
 *
 * <term>  ::=  <factor> [ [ "*" | "/" ] <factor> ]...
 *
 * <factor>  ::=  <primary> [ "^" <factor> ]...
 *
 * <primary>  ::=  <number> | <variable> | "(" <expression> ")"
 * <p>
 * 입력 라인은 정확히 하나의 이러한 명령을 포함해야 합니다. 표현식을 읽은 후에 라인에 추가 데이터가 있으면 오류로 간주됩니다. "pi"와 "e" 변수는 프로그램이 시작할 때 기본 수학 상수를 나타내도록 정의되어 있습니다.
 * <p>
 * 이 프로그램은 심볼 테이블로서 HashMap 사용을 보여줍니다.
 * <p>
 * SimpleInterpreter.java는 SimpleParser2.java 프로그램을 기반으로 합니다.
 * 이 프로그램은 비표준 클래스 TextIO를 사용합니다.
 * <p>
 * 프로그램은 변수, 숫자, 연산자 및 괄호를 포함하는 표현식을 처리 할 수 있다.
 * 1 : sin, cos, tan, abs, sqrt, log를 처리
 * ex) x, y에 값이 할당된 경우 sin(3*x+7) + log(sqrt(y))같은 표현식을 풀이할 수 있어야 함.
 * 함수의 이름 뒤에는 괄호로 둘러싸인 식이 따라와야 한다.
 */

import com.nhnacademy.main.exercise7.textio.TextIO;

import java.util.HashMap;

public class SimpleInterpreter {

    /**
     * 사용자의 입력에서 찾은 구문 오류를 나타냅니다.
     */
    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // 중첩 클래스 ParseError 끝

    /**
     * symbolTable에 변수 값에 관한 정보를 포함합니다.
     * 변수에 값이 할당되면 심볼 테이블에 기록됩니다.
     * 키는 변수의 이름이고 값은 변수의 값을 포함하는 Double 유형 객체입니다.
     * (HashMap은 기본 유형 double에 속하는 객체를 포함할 수 없기 때문에 래퍼 클래스 Double을 사용합니다.)
     */
    private static HashMap<String, Object> symbolTable;

    public static void main(String[] args) {

        // 심볼 테이블을 나타내는 맵 생성
        symbolTable = new HashMap<>();

        symbolTable.put("pi", new StandardFunction(StandardFunction.Functions.PI));
        symbolTable.put("e", new StandardFunction(StandardFunction.Functions.E));
        symbolTable.put("sin", new StandardFunction(StandardFunction.Functions.SIN));
        symbolTable.put("cos", new StandardFunction(StandardFunction.Functions.COS));
        symbolTable.put("tan", new StandardFunction(StandardFunction.Functions.TAN));
        symbolTable.put("log", new StandardFunction(StandardFunction.Functions.LOG));
        symbolTable.put("abs", new StandardFunction(StandardFunction.Functions.ABS));
        symbolTable.put("sqrt", new StandardFunction(StandardFunction.Functions.SQRT));

        System.out.println("\n\n명령을 입력하십시오. 종료하려면 반환 키를 누르십시오.");
        System.out.println("명령은 다음 형식이어야 합니다:\n");
        System.out.println("      print <expression>");
        System.out.println("  또는");
        System.out.println("      let <variable> = <expression>");

        while (true) {
            TextIO.put("\n?  ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n') {
                break; // 빈 입력 라인은 while 루프와 프로그램을 종료합니다.
            }
            try {
                String command = TextIO.getWord();
                if (command.equalsIgnoreCase("print"))
                    doPrintCommand();
                else if (command.equalsIgnoreCase("let"))
                    doLetCommand();
                else
                    throw new ParseError("명령은 'print' 또는 'let'로 시작해야 합니다.");
                TextIO.getln();
            } catch (ParseError e) {
                System.out.println("\n*** 입력 오류: " + e.getMessage());
                System.out.println("*** 입력을 삭제합니다: " + TextIO.getln());
            }
        }

        System.out.println("\n\n완료.");

    } // main() 끝

    /**
     * "let <variable> = <expression>" 형식의 명령을 처리합니다.
     * 이 메서드가 호출될 때 "let" 단어가 이미 읽혔습니다.
     * 변수 이름과 표현식을 읽고 변수의 값을 심볼 테이블에 저장합니다.
     */
    private static void doLetCommand() throws ParseError {
        TextIO.skipBlanks();
        if (!Character.isLetter(TextIO.peek()))
            throw new ParseError("'let' 다음에 변수 이름이 와야 합니다.");
        String varName = readWord(); // 변수 이름
        TextIO.skipBlanks();
        if (TextIO.peek() != '=')
            throw new ParseError("'let' 명령에 대한 '=' 연산자가 필요합니다.");
        TextIO.getChar();
        double val = expressionValue(); // 변수의 값
        TextIO.skipBlanks();
        if (TextIO.peek() != '\n')
            throw new ParseError("표현식 끝에 추가 데이터가 있습니다.");

        if (symbolTable.get(varName) instanceof StandardFunction) {
            throw new ParseError("미리 선언된 변수를 바꿀 수 없습니다!");
        }

        symbolTable.put(varName, val); // 심볼 테이블에 추가
        System.out.println("ok");
    }

    /**
     * "print <expression>" 형식의 명령을 처리합니다.
     * 이 메서드가 호출될 때 "print" 단어가 이미 읽혔습니다.
     * 표현식을 계산하고 값을 출력합니다.
     */
    private static void doPrintCommand() throws ParseError {
        double val = expressionValue();
        TextIO.skipBlanks();
        if (TextIO.peek() != '\n')
            throw new ParseError("표현식 끝에 추가 데이터가 있습니다.");
        System.out.println("값은 " + val);
    }

    /**
     * 현재 입력 라인에서 표현식을 읽고 해당 값을 반환합니다.
     */
    private static double expressionValue() throws ParseError {
        TextIO.skipBlanks();
        boolean negative; // 음수 부호가 있는 경우 true입니다.
        negative = false;
        if (TextIO.peek() == '-') {
            TextIO.getAnyChar();
            negative = true;
        }
        double val; // 표현식의 값
        val = termValue(); // 표현식은 항으로 시작해야 합니다.
        if (negative)
            val = -val; // 음수 부호 적용
        TextIO.skipBlanks();
        while (TextIO.peek() == '+' || TextIO.peek() == '-') {
            // 다음 항을 읽어서 이전 항의 값에 더하거나 빼기 위해
            // 표현식의 이전 항에 값을 추가합니다.
            char op = TextIO.getAnyChar();
            double nextVal = termValue();
            if (op == '+')
                val += nextVal;
            else
                val -= nextVal;
            TextIO.skipBlanks();
        }
        return val;
    } // expressionValue() 끝

    /**
     * 현재 입력 라인에서 항을 읽고 해당 값을 반환합니다.
     */
    private static double termValue() throws ParseError {
        TextIO.skipBlanks();
        double val; // 항의 값
        val = factorValue(); // 항은 인수로 시작해야 합니다.
        TextIO.skipBlanks();
        while (TextIO.peek() == '*' || TextIO.peek() == '/') {
            // 다음 인수를 읽고 값을 곱하거나 나누기 위해
            // 현재까지의 값을 이 인수의 값으로 곱하거나 나눕니다.
            char op = TextIO.getAnyChar();
            double nextVal = factorValue();
            if (op == '*')
                val *= nextVal;
            else
                val /= nextVal;
            TextIO.skipBlanks();
        }
        return val;
    } // termValue() 끝

    /**
     * 현재 입력 라인에서 인수를 읽고 해당 값을 반환합니다.
     * (참고: 지수 연산자 "^"는 오른쪽 연관입니다. 즉,
     * a^b^c는 a^(b^c)를 의미하며 (a^b)^c가 아닙니다.
     * primary의 BNF 정의는 이 사실을 고려합니다.)
     */
    private static double factorValue() throws ParseError {
        TextIO.skipBlanks();
        Object obj = primaryValue();
        double val = 0;
        if (obj instanceof Double) {
            val = (Double) obj; // 인수는 기본 항목으로 시작해야 합니다.
            TextIO.skipBlanks();
            if (TextIO.peek() == '^') {
                // 다음 인수를 읽고 현재 값을 이 인수의 값으로 거듭 제곱합니다.
                TextIO.getChar();
                double nextVal = factorValue();
                val = Math.pow(val, nextVal);
                if (Double.isNaN(val))
                    throw new ParseError("^ 연산자에 잘못된 값이 있습니다.");
                TextIO.skipBlanks();
            }

        } else if (obj instanceof StandardFunction) {
            StandardFunction standardFunction = (StandardFunction) obj;
            val = (double) primaryValue();
            TextIO.skipBlanks();
            return standardFunction.evaluate(val);
        }
        return val;
    } // factorValue() 끝

    /**
     * 현재 입력 라인에서 기본 항목을 읽고 해당 값을 반환합니다.
     * 기본 항목은 숫자, 변수 또는 괄호로 시작해야 합니다.
     */
    private static Object primaryValue() throws ParseError {
        TextIO.skipBlanks();
        char ch = TextIO.peek();
        if (Character.isDigit(ch)) {
            // 인수가 숫자입니다. 그 값을 읽고 반환합니다.
            return TextIO.getDouble();
        } else if (Character.isLetter(ch)) {
            // 인수가 변수입니다. 변수 이름을 읽고
            // 해당 값을 심볼 테이블에서 찾습니다. 변수가
            // 심볼 테이블에 없는 경우 오류가 발생합니다.
            // (심볼 테이블의 값은 Double 유형의 객체입니다.)
            String name = readWord();
            Object obj = symbolTable.get(name);
            return obj;

        } else if (ch == '(') {
            // 인수가 괄호로 둘러싸인 표현식입니다.
            // 표현식의 값을 반환합니다.
            TextIO.getAnyChar(); // "("를 읽음
            double val = expressionValue();
            TextIO.skipBlanks();
            if (TextIO.peek() != ')')
                throw new ParseError("오른쪽 괄호가 누락되었습니다.");
            TextIO.getAnyChar(); // ")"를 읽음
            return val;
        } else if (ch == '\n')
            throw new ParseError("표현식 중간에 줄의 끝이 나왔습니다.");
        else if (ch == ')')
            throw new ParseError("불필요한 오른쪽 괄호입니다.");
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            throw new ParseError("잘못된 연산자가 위치했습니다.");

        throw new ParseError("예기치 않은 문자 \"" + ch + "\"가 나타났습니다.");
    } // primaryValue() 끝

    /**
     * 입력에서 단어를 읽습니다. 단어는 문자와 숫자의 연속입니다.
     * 이 서브 루틴을 호출할 때 이미 입력의 다음 문자가 문자임이 알려져 있어야 합니다.
     */
    private static String readWord() {
        String word = ""; // 단어
        char ch = TextIO.peek();
        while (Character.isLetter(ch) || Character.isDigit(ch)) {
            word += TextIO.getChar(); // 문자를 단어에 추가
            ch = TextIO.peek();
        }
        return word;
    }

} // SimpleInterpreter 클래스 끝
