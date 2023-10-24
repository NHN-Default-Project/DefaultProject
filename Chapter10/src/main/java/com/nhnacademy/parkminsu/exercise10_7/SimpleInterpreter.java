package com.nhnacademy.parkminsu.exercise10_7;
/**
 * 이 프로그램은 숫자, 변수, 괄호 및 연산자 +, -, *, / 및 ^ (거듭제곱을 나타냄)를 포함할 수 있는 식을 계산할 수 있습니다.
 * 변수 이름은 문자와 숫자로 구성되어야하며, 문자로 시작해야 합니다. 이름은 대소 문자를 구분합니다.
 * 이 프로그램은 사용자로부터 두 가지 유형의 명령을 수용합니다.
 * "print <expression>" 형식의 명령의 경우 식을 계산하고 값을 출력합니다.
 * "let <variable> = <expression>" 형식의 명령의 경우 식을 계산하고 값을 변수에 할당합니다.
 * 변수에 값이 할당되기 전에 표현식에서 변수를 사용하면 오류가 발생합니다. 숫자는 숫자로 시작해야합니다.
 * <p>
 * 명령은 다음 BNF 규칙에 의해 공식적으로 정의됩니다.
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
 * 입력 라인은 정확히 이러한 명령 중 하나를 포함해야합니다. 식을 읽은 후 라인에 추가 데이터가 있다면 오류로 간주됩니다.
 * 프로그램 시작시 변수 "pi" 및 "e"가 수학적 상수를 나타내도록 기호 테이블에 추가합니다.
 * <p>
 * 이 프로그램은 심볼 테이블로 HashMap을 사용하는 방법을 보여줍니다.
 * <p>
 * SimpleInterpreter.java는 SimpleParser2.java 프로그램을 기반으로합니다.
 * 비표준 클래스인 TextIO를 사용합니다.
 */


import com.nhnacademy.parkminsu.exercise10_7.textio.TextIO;

import java.util.HashMap;

public class SimpleInterpreter {

    /**
     * 사용자 입력에서 발견된 구문 오류를 나타냅니다.
     */
    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // 중첩 클래스 ParseError의 끝

    private enum Functions {SIN, COS, TAN, ABS, SQRT, LOG}

    /**
     * 이 클래스의 객체는 표준 함수 중 하나를 나타냅니다.
     */
    private static class StandardFunction {

        /**
         * 이 함수가 무엇을 나타내는지 알려줍니다.
         */
        Functions functionCode;

        /**
         * Constructor는 표준 함수 중 하나를 나타내는 객체를 생성합니다.
         *
         * @param code 나타내는 함수.
         */
        StandardFunction(Functions code) {
            functionCode = code;
        }

        /**
         * 지정된 매개변수 값 x에 대한 이 함수의 값을 찾습니다.
         */
        double evaluate(double x) {
            // ("switch 표현식" 구문을 사용합니다)
            switch (functionCode) {
                case SIN:
                    return Math.sin(x);
                case COS:
                    return Math.cos(x);
                case TAN:
                    return Math.tan(x);
                case ABS:
                    return Math.abs(x);
                case SQRT:
                    return Math.sqrt(x);
                default:
                    return Math.log(x);
            }
        }

        @Override
        public String toString() {
            return "" + functionCode;

        }
    } // end class StandardFunction

    /**
     * symbolTable에는 변수의 값을 나타내는 정보가 포함되어 있습니다.
     * 변수에 값이 할당되면 심볼 테이블에 기록됩니다.
     * 키는 변수의 이름이며,
     * 값은 변수의 값이 포함 된 Double 유형의 객체입니다.
     * (기본 유형 double에 속하는 객체가 포함 될 수 없으므로 래퍼 클래스 Double을 사용합니다.)
     */
    private static HashMap<String, Object> symbolTable; // symbolTable

    public static void main(String[] args) {

        // 심볼 테이블을 나타내는 맵을 생성합니다.

        symbolTable = new HashMap<>();

        // 시작할 때 "pi" 및 "e"라는 변수를 심볼 테이블에 추가합니다.
        // 그 값은 일반적인 수학 상수를 나타냅니다.

        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);
        symbolTable.put("sin", new StandardFunction(Functions.SIN));
        symbolTable.put("cos", new StandardFunction(Functions.SIN));
        symbolTable.put("tan", new StandardFunction(Functions.SIN));
        symbolTable.put("abs", new StandardFunction(Functions.SIN));
        symbolTable.put("sqrt", new StandardFunction(Functions.SIN));
        symbolTable.put("log", new StandardFunction(Functions.SIN));

        System.out.println("\n\n명령을 입력하십시오. 입력을 종료하려면 리턴 키를 누릅니다.");
        System.out.println("명령은 다음 형식이어야합니다:\n");
        System.out.println("      print <expression>");
        System.out.println("또는");
        System.out.println("      let <variable> = <expression>");

        while (true) {
            TextIO.put("\n?  ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n') {
                break;  // 빈 입력 줄은 while 루프와 프로그램을 종료합니다.
            }
            try {
                String command = TextIO.getWord();
                if (command.equalsIgnoreCase("print")) {

                    doPrintCommand();
                } else if (command.equalsIgnoreCase("let")) {
                    doLetCommand();
                } else {
                    throw new ParseError("명령은 'print' 또는 'let'로 시작해야합니다.");
                }
                TextIO.getln();
            } catch (ParseError e) {
                System.out.println("\n*** 입력 오류: " + e.getMessage());
                System.out.println("*** 입력을 버립니다: " + TextIO.getln());
            }
        }

        System.out.println("\n\n완료.");

    } // main() 끝

    /**
     * "let <variable> = <expression>" 형식의 명령을 처리합니다.
     * 이 메서드가 호출될 때 "let" 단어가 이미 읽혔습니다.
     * 변수 이름과 식을 읽고 변수의 값을 심볼 테이블에 저장합니다.
     */
    private static void doLetCommand() throws ParseError {
        TextIO.skipBlanks();
        if (!Character.isLetter(TextIO.peek()))
            throw new ParseError("'let' 다음에 변수 이름이 예상됩니다.");
        String varName = readWord();  // 변수 이름.
        TextIO.skipBlanks();
        if (TextIO.peek() != '=')
            throw new ParseError("'let' 명령에 대한 '=' 연산자가 예상됩니다.");
        TextIO.getChar();
        Double val = expressionValue();  // 변수의 값.
        TextIO.skipBlanks();
        if (TextIO.peek() != '\n')
            throw new ParseError("식 끝 이후 추가 데이터가 있습니다.");

        symbolTable.put(varName, val);  // 심볼 테이블에 추가합니다.
        System.out.println("OK");
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
            throw new ParseError("식 끝 이후 추가 데이터가 있습니다.");
        System.out.println("값은 " + val);
    }

    /**
     * 현재 입력 라인에서 표현식을 읽고 값을 반환합니다.
     */
    private static double expressionValue() throws ParseError {
        TextIO.skipBlanks();
        boolean negative;  // 첫 번째 마이너스 기호가 있는 경우 true입니다.
        negative = false;
        if (TextIO.peek() == '-') {
            TextIO.getAnyChar();
            negative = true;
        }
        double val;  // 표현식의 값.
        val = termValue();  // 표현식은 항으로 시작해야합니다.
        if (negative)
            val = -val; // 첫 번째 마이너스 기호를 적용합니다.
        TextIO.skipBlanks();
        while (TextIO.peek() == '+' || TextIO.peek() == '-') {
            // 다음 항을 읽어서 표현식의 이전 항에 더하거나 빼줍니다.
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
     * 현재 입력 라인에서 항을 읽고 값을 반환합니다.
     */
    private static double termValue() throws ParseError {
        TextIO.skipBlanks();
        double val;  // 항의 값.
        val = factorValue();  // 항은 인수로 시작해야합니다.
        TextIO.skipBlanks();
        while (TextIO.peek() == '*' || TextIO.peek() == '/') {
            // 다음 인수를 읽어서 값을 곱하거나 나눕니다.
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
     * 현재 입력 라인에서 인수를 읽고 값을 반환합니다.
     * (참고: 지수 연산자 "^"는 오른쪽 연관입니다.
     * 즉, a^b^c는 a^(b^c)를 의미하며 (a^b)^c가 아닙니다.
     * primary의 BNF 정의는 이 사실을 고려합니다.)
     */
    private static double factorValue() throws ParseError {
        TextIO.skipBlanks();
        double val;  // 인수의 값.
        val = primaryValue();  // 인수는 기본 요소로 시작해야합니다.
        TextIO.skipBlanks();
        if (TextIO.peek() == '^') {
            // 다음 인수를 읽어서 값을 지수화합니다.
            TextIO.getChar();
            double nextVal = factorValue();
            val = Math.pow(val, nextVal);
            if (Double.isNaN(val))
                throw new ParseError("^ 연산자에 대한 잘못된 값입니다.");
            TextIO.skipBlanks();
        }
        return val;
    } // factorValue() 끝

    /**
     * 현재 입력 라인에서 기본 요소를 읽고 값을 반환합니다.
     * (참고: 지수 연산자 "^"는 오른쪽 연관입니다.
     * 즉, a^b^c는 a^(b^c)를 의미하며 (a^b)^c가 아닙니다.
     * primary의 BNF 정의는 이 사실을 고려합니다.)
     */
    private static double primaryValue() throws ParseError {
        TextIO.skipBlanks();
        char ch = TextIO.peek();
        if (Character.isDigit(ch)) {
            // 인수는 숫자입니다. 숫자를 읽고 값을 반환합니다.
            return TextIO.getDouble();
        } else if (Character.isLetter(ch)) {
            // 인수는 변수입니다. 이름을 읽고 심볼 테이블에서 해당 변수의 값을 찾습니다.
            // 변수가 심볼 테이블에 없으면 오류가 발생합니다. (심볼 테이블의 값은 Double 형식의 객체임을 주의하세요.)
            String name = readWord();
            Object obj = symbolTable.get(name);
            Double val = null;
            StandardFunction standardFunction = new StandardFunction(null);
            for (Functions functions : Functions.values()) {
                if (functions.name().toString().equals(name.toUpperCase())) {
                    standardFunction = new StandardFunction(functions);
                }
            }
            if (obj instanceof Double) {
                val = (Double) symbolTable.get(name);
            } else {
                TextIO.skipBlanks();
                if (TextIO.peek() == '(') {
                    TextIO.getAnyChar();
                }
                System.out.println(name);
                double num = expressionValue();
                if (TextIO.peek() == ')') {
                    TextIO.getAnyChar();
                }
                val = standardFunction.evaluate(num);

            }

            if (val == null)
                throw new ParseError("알 수 없는 변수 \"" + name + "\"");
            return val.doubleValue();
        } else if (ch == '(') {
            // 인수는 괄호 안의 표현식입니다.
            // 표현식의 값을 반환합니다.
            TextIO.getAnyChar();  // "("를 읽음
            double val = expressionValue();
            TextIO.skipBlanks();
            if (TextIO.peek() != ')')
                throw new ParseError("오른쪽 괄호가 누락되었습니다.");
            TextIO.getAnyChar();  // ")"를 읽음
            return val;
        } else if (ch == '\n')
            throw new ParseError("식 중간에 라인 끝이 나타남.");
        else if (ch == ')')
            throw new ParseError("여분의 오른쪽 괄호가 있습니다.");
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            throw new ParseError("잘못된 위치에 연산자가 있습니다.");
        else
            throw new ParseError("예기치 않은 문자 \"" + ch + "\"가 나타남.");
    }  // primaryValue() 끝

    /**
     * 입력에서 단어를 읽어 반환합니다.
     * 단어는 문자와 숫자의 연속입니다.
     * 이 서브루틴이 호출될 때 입력의 다음 문자가 문자임이 이미 알려져야합니다.
     */
    private static String readWord() {
        String word = "";  // 단어.
        char ch = TextIO.peek();
        while (Character.isLetter(ch) || Character.isDigit(ch)) {
            word += TextIO.getChar(); // 문자를 단어에 추가합니다.
            ch = TextIO.peek();
        }
        return word;
    }

} // SimpleInterpreter 클래스 끝
