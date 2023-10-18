package com.nhnacademy.yunhwa.exercise10_7;

/*
* ============ 참고 자료 ==============
* 수학 및 프로그래밍에서 사용되는 각 용어의 의미
*
* Expression (식):
* 일반적으로 수학이나 프로그래밍에서 계산을 나타내는 구조를 말합니다.
* 숫자, 변수, 연산자 등의 조합으로 이루어집니다.
* 예시: 2 + 3 * x
*
* Term (항):
* 식을 구성하는 단위로서, 덧셈과 뺄셈으로 구분되는 부분입니다.
* 하나 이상의 요소들이 곱셈 또는 나눗셈으로 연결됩니다.
* 예시: 3x, 4y^2
*
* Factor (인자):
* 항을 구성하는 작은 요소로서, 곱셈 또는 나눗셈 연산의 피연산자입니다.
* 숫자, 변수, 상수, 함수 등이 될 수 있습니다.
* 예시: 3, x^2, sin(x)
* */

/*
    This program can evaluate expressions that can include
    numbers, variables, parentheses, and the operators +,
    -, *, /, and ^ (where ^ indicates raising to a power).
    A variable name must consist of letters and digits,
    beginning with a letter.  Names are case-sensitive.
    This program accepts commands of two types from the user.
    For a command of the form  print <expression> , the expression
    is evaluated and the value is output.  For a command of
    the form  let <variable> = <expression> , the expression is
    evaluated and the value is assigned to the variable.
    If a variable is used in an expression before it has been
    assigned a value, an error occurs.  A number must begin with
    a digit (i.e., not a decimal point).

    Commands are formally defined by the BNF rules:

            <command>  ::=  "print" <expression>
                               |  "let" <variable> "=" <expression>

            <expression>  ::=  [ "-" ] <term> [ [ "+" | "-" ] <term> ]...

            <term>  ::=  <factor> [ [ "*" | "/" ] <factor> ]...

            <factor>  ::=  <primary> [ "^" <factor> ]...

            <primary>  ::=  <number> | <variable> | <standard function> | "(" <expression> ")"

    A line of input must contain exactly one such command.  If extra
    data is found on a line after an expression has been read, it is
    considered an error.  The variables "pi" and "e" are defined
    when the program starts to represent the usual mathematical
    constants.

    This program demonstrates the use of a HashMap as a symbol
    table.

    SimpleInterpreter.java is based on the program SimpleParser2.java.
    It uses the non-standard class, TextIO.
 */

import com.nhnacademy.yunhwa.exercise10_6.text_io.TextIO;

import java.util.HashMap;

public class SimpleInterpreter {

    private enum Functions {SIN, COS, TAN, ABS, SQRT, LOG}

    /**
     * An object of this class represents one of the standard functions.
     */
    private static class StandardFunction {

        /**
         * Tells which function this is.
         */
        Functions functionCode;

        /**
         * Constructor creates an object to represent one of
         * the standard functions
         *
         * @param code which function is represented.
         */
        StandardFunction(Functions code) {
            functionCode = code;
        }

        /**
         * Finds the value of this function for the specified
         * parameter value, x.
         */
        double evaluate(double x) {
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
                case LOG: // 자연(e) 로그 계산기
                    return Math.log(x);
            }
            return Double.NaN;
        }

    } // end class StandardFunction

    /**
     * Represents a syntax error found in the user's input.
     */
    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // end nested class ParseError


    /**
     * The symbolTable contains information about the
     * values of variables.  When a variable is assigned
     * a value, it is recorded in the symbol table.
     * The key is the name of the variable, and the
     * value is an object of type Double that contains
     * the value of the variable.  (The wrapper class
     * Double is used, since a HashMap cannot contain
     * objects belonging to the primitive type double.)
     */
    private static HashMap<String, Object> symbolTable;


    public static void run() {

        // Create the map that represents symbol table.
        symbolTable = new HashMap<>();

        makeDefaultSymbolTable();

        System.out.println("\n\nEnter commands; press return to end.");
        System.out.println("Commands must have the form:\n");
        System.out.println("      print <expression>");
        System.out.println("  or");
        System.out.println("      let <variable> = <expression>");

        while (true) {
            TextIO.put("\n?  ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n') {
                break;  // A blank input line ends the while loop and the program.
            }
            try {
                String command = TextIO.getWord();
                if (command.equalsIgnoreCase("print"))
                    doPrintCommand();
                else if (command.equalsIgnoreCase("let"))
                    doLetCommand();
                else
                    throw new ParseError("Command must begin with 'print' or 'let'.");
                TextIO.getln();
            } catch (ParseError e) {
                System.out.println("\n*** Error in input:    " + e.getMessage());
                System.out.println("*** Discarding input:  " + TextIO.getln());
            }
        }

        System.out.println("\n\nDone.");

    } // end main()

    public static void makeDefaultSymbolTable() {
        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);

        symbolTable.put("sin", new StandardFunction(Functions.SIN));
        symbolTable.put("cos", new StandardFunction(Functions.COS));
        symbolTable.put("tan", new StandardFunction(Functions.TAN));
        symbolTable.put("abs", new StandardFunction(Functions.ABS));
        symbolTable.put("sqrt", new StandardFunction(Functions.SQRT));
        symbolTable.put("log", new StandardFunction(Functions.LOG));
    }

    public static void checkValidKeyBeforePut(String varName) throws ParseError {
        if (varName.equals("sin") || varName.equals("cos") || varName.equals("tan")
        || varName.equals("abs") || varName.equals("sqrt") || varName.equals("log")) {
            throw new ParseError(" StandardFunction in Symbol Table shouldn't update value.");
        } else if (varName.equals("pi") || varName.equals("e")) {
            throw new ParseError(" (π, e) are the usual mathematical constants, so they shouldn't update value");
        }
    }


    /**
     * Process a command of the form  let <variable> = <expression>.
     * When this method is called, the word "let" has already
     * been read.  Read the variable name and the expression, and
     * store the value of the variable in the symbol table.
     */
    private static void doLetCommand() throws ParseError {
        TextIO.skipBlanks();
        if (!Character.isLetter(TextIO.peek()))
            throw new ParseError("Expected variable name after 'let'.");
        String varName = readWord();  // The name of the variable.
        TextIO.skipBlanks();
        if (TextIO.peek() != '=')
            throw new ParseError("Expected '=' operator for 'let' command.");
        TextIO.getChar();
        double val = expressionValue();  // The value of the variable.
        TextIO.skipBlanks();
        if (TextIO.peek() != '\n')
            throw new ParseError("Extra data after end of expression.");
        checkValidKeyBeforePut(varName);
        symbolTable.put(varName, val);  // Add to symbol table.
        System.out.println("ok");
    }

    /**
     * Process a command of the form  print <expression>.
     * When this method is called, the word "print" has already
     * been read.  Evaluate the expression and print the value.
     */
    private static void doPrintCommand() throws ParseError {
        double val = expressionValue();
        TextIO.skipBlanks();
        if (TextIO.peek() != '\n')
            throw new ParseError("Extra data after end of expression.");
        System.out.println("Value is " + val);
    }


    /**
     * Read an expression from the current line of input and return its value.
     */
    private static double expressionValue() throws ParseError { // 식 : 덧셈과 뺄셈의 조합으로 이루어진 부분
        TextIO.skipBlanks();
        boolean negative;  // True if there is a leading minus sign.
        negative = false;
        if (TextIO.peek() == '-') {
            TextIO.getAnyChar();
            negative = true;
        }
        double val;  // Value of the expression.
        val = termValue();  // An expression must start with a term.
        if (negative)
            val = -val; // Apply the leading minus sign
        TextIO.skipBlanks();
        while (TextIO.peek() == '+' || TextIO.peek() == '-') {
            // Read the next term and add it to or subtract it from
            // the value of previous terms in the expression.
            char op = TextIO.getAnyChar();
            double nextVal = termValue();
            if (op == '+')
                val += nextVal;
            else
                val -= nextVal;
            TextIO.skipBlanks();
        }
        return val;
    } // end expressionValue()


    /**
     * Read a term from the current line of input and return its value.
     */
    private static double termValue() throws ParseError {
        // 항 : 곱셈 또는 나눗셈으로 연결되는 부분 (ex : 3*x, 4*y^2)
        TextIO.skipBlanks();
        double val;  // The value of the term.
        val = factorValue();  // A term must start with a factor.
        TextIO.skipBlanks();
        while (TextIO.peek() == '*' || TextIO.peek() == '/') {
            // Read the next factor, and multiply or divide
            // the value-so-far by the value of this factor.
            char op = TextIO.getAnyChar();
            double nextVal = factorValue();
            if (op == '*')
                val *= nextVal;
            else
                val /= nextVal;
            TextIO.skipBlanks();
        }
        return val;
    } // end termValue()


    /**
     * Read a factor from the current line of input and return its value.
     * (Note:  The exponentiation operator, "^", is right associative.  That is,
     * a^b^c means a^(b^c), not (a^b)^c.  The BNF definition of primary takes
     * this into account.
     */
    private static double factorValue() throws ParseError {
        // 인자 : 곱셈 or 나눗셈의 피연산자 / 숫자, 변수, 상수, 함수 등이 될 수 있음. (ex : 3, x^2, sin(x))
        TextIO.skipBlanks();

        Double doubleVal; // Value of the factor.
        StandardFunction standardFunction;
        Object o = primaryValue();  // A factor must start with a primary.

        if (o instanceof Double) {
            doubleVal = (double) o;
            TextIO.skipBlanks();

            if (TextIO.peek() == '^') {
                // Read the next factor, and exponentiate
                // the value by the value of that factor.
                TextIO.getChar();
                double nextVal = factorValue();
                doubleVal = Math.pow(doubleVal, nextVal);
                if (Double.isNaN(doubleVal))
                    throw new ParseError("Illegal values for ^ operator.");
                TextIO.skipBlanks();
            }
            return doubleVal;

        } else if (o instanceof StandardFunction) { // 다음으로 ( ~~ ) 받아서 연산 처리해야함.
            standardFunction = (StandardFunction) o;
            double val = (double) primaryValue();
            TextIO.skipBlanks();
            return standardFunction.evaluate(val);
        }
        return Double.NaN;
    } // end factorValue()


    /**
     * Read a primary from the current line of input and
     * return its value.  A primary must be a number,
     * a variable, or an expression enclosed in parentheses.
     */
    private static Object primaryValue() throws ParseError {
        TextIO.skipBlanks();
        char ch = TextIO.peek();
        if (Character.isDigit(ch)) {
            // The factor is a number.  Read it and
            // return its value.
            return TextIO.getDouble();
        } else if (Character.isLetter(ch)) {
            // The factor is a variable.  Read its name and
            // look up its value in the symbol table.  If the
            // variable is not in the symbol table, an error
            // occurs.  (Note that the values in the symbol
            // table are objects of type Double.)
            String name = readWord();
            Double doubleVal;
            StandardFunction standardFunction;
            Object o = symbolTable.get(name);
            if (o == null)
                throw new ParseError("Unknown variable or Unknown StandardFunction \"" + name + "\"");

            if (o instanceof Double) {
                doubleVal = (double) o;
                return doubleVal.doubleValue();

            } else if (o instanceof StandardFunction) {
                standardFunction = (StandardFunction) o;
                return standardFunction;
            }

        } else if (ch == '(') {
            // The factor is an expression in parentheses.
            // Return the value of the expression.
            TextIO.getAnyChar();  // Read the "("
            double val = expressionValue();
            TextIO.skipBlanks();
            if (TextIO.peek() != ')')
                throw new ParseError("Missing right parenthesis.");
            TextIO.getAnyChar();  // Read the ")"
            return val;

        } else if (ch == '\n')
            throw new ParseError("End-of-line encountered in the middle of an expression.");
        else if (ch == ')')
            throw new ParseError("Extra right parenthesis.");
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            throw new ParseError("Misplaced operator.");
        else
            throw new ParseError("Unexpected character \"" + ch + "\" encountered.");
        return null; ////////////////////////////////////////////////////
    }  // end primaryValue()


    /**
     * Reads a word from input.  A word is any sequence of
     * letters and digits, starting with a letter.  When
     * this subroutine is called, it should already be
     * known that the next character in the input is
     * a letter.
     */
    private static String readWord() {
        String word = "";  // The word.
        char ch = TextIO.peek();
        while (Character.isLetter(ch) || Character.isDigit(ch)) {
            word += TextIO.getChar(); // Add the character to the word.
            ch = TextIO.peek();
        }
        return word;
    }

} // end class SimpleInterpreter