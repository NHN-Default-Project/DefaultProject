package com.nhnacademy.yunhwa.exercise9_6;

import com.nhnacademy.yunhwa.exercise9_2.TextIO;

/**
 This program reads standard expressions typed in by the user.
 The program constructs an expression tree to represent the
 expression.  It then prints the value of the tree.  It also uses
 the tree to print out a list of commands that could be used
 on a stack machine to evaluate the expression.
 The expressions can use positive real numbers and
 the binary operators +, -, *, and /.  The unary minus operation
 is supported.  The expressions are defined by the BNF rules:

 <expression>  ::=  [ "-" ] <term> [ [ "+" | "-" ] <term> ]...

 <term>  ::=  <factor> [ [ "*" | "/" ] <factor> ]...

 <factor>  ::=  <number>  |  <x-variable>  |  "(" <expression> ")"

 A number must begin with a digit (i.e., not a decimal point).
 A line of input must contain exactly one such expression.  If extra
 data is found on a line after an expression has been read, it is
 considered an error.

 In addition to the main program class, SimpleParser3, this program
 defines a set of four nested classes for implementing expression trees.

 */

public class SimpleParser3 {

    //    -------------------- Nested classes for Expression Trees ------------------------------


    /**
     *  An abstract class representing any node in an expression tree.
     *  The three concrete node classes are concrete subclasses.
     *  Two instance methods are specified, so that they can be used with
     *  any ExpNode.  The value() method returns the value of the
     *  expression.  The printStackCommands() method prints a list
     *  of commands that could be used to evaluate the expression on
     *  a stack machine (assuming that the value of the expression is
     *  to be left on the stack).
     */
    abstract private static class ExpNode {
        abstract double value(double xValue);
        abstract void printStackCommands();
        abstract void printInfixExpression();
        abstract void printInfixExpressionSubstituted(double xValue);

        abstract double derivativeValue(double xValue);
        abstract void printDerivativeStackCommands(double xValue);
        abstract void printInfixDerivative();
        abstract void printInfixDerivativeValue(double xValue);
        abstract ExpNode derivative();
    }

    /**
     * Represents an expression node that holds a number.
     */
    private static class ConstNode extends ExpNode { // c
        double number;  // The number.
        ConstNode(double val) {
            // Construct a ConstNode containing the specified number.
            this.number = val;
        }

        @Override
        double value(double xValue) {
            // The value of the node is the number that it contains.
            return this.number;
        }

        @Override
        ExpNode derivative() {
            return new ConstNode(0);
        }

        void printStackCommands() {
            // On a stack machine, just push the number onto the stack.
            System.out.println("  Push " + this.number);
        }

        @Override
        double derivativeValue(double xValue) {
            return derivative().value(xValue);
        }

        @Override
        void printDerivativeStackCommands(double xValue) { // 도함수에 대입한 결과 출력
            System.out.println("  Push " + derivative().value(xValue));
        }

        @Override
        void printInfixExpression() {
            // 완전히 괄호로 묶은 표현식으로 인쇄
            System.out.print(this.number);
        }

        @Override
        void printInfixDerivative() {
            System.out.print(derivative());
        }

        @Override
        void printInfixExpressionSubstituted(double xValue) {
            System.out.print(value(xValue));
        }

        @Override
        void printInfixDerivativeValue(double xValue) {
            System.out.print(derivativeValue(xValue));
        }



        @Override
        public String toString() {
            return String.valueOf(this.number);
        }
    }

    private static class VariableNode extends ExpNode { // x
        double xValue; // 나중에 대입될 값
        VariableNode() {
            // Construct a VariableNode
        }

        @Override
        double value(double xValue) {
            // The value of the node is the result.
            this.xValue = xValue;
            return this.xValue;
        }

        @Override
        ExpNode derivative() {
            return new ConstNode(1);
        }

        void printStackCommands() { // 대입한 값 출력
            // On a stack machine, just push the variable value onto the stack.
            System.out.println("  Push x " + this.xValue);
        }

        @Override
        double derivativeValue(double xValue) { // 미분해서 대입한 값 반환
            return derivative().value(xValue); // 항상 1이 나와야 함.
        }

        @Override
        void printDerivativeStackCommands(double xValue) {
            System.out.println("  Push x " + derivative().value(xValue));
        }

        @Override
        void printInfixExpression() {
            System.out.print("x");
        }

        @Override
        void printInfixExpressionSubstituted(double xValue) {
            System.out.print(this.xValue);
        }

        @Override
        void printInfixDerivative() {
            System.out.print(derivative());
        }

        @Override
        void printInfixDerivativeValue(double xValue) {
            System.out.print(derivativeValue(xValue));
        }



        @Override
        public String toString() {
            return "x";
        }
    }

    /**
     * An expression node representing a binary operator.
     */
    private static class BinOpNode extends ExpNode {
        char op;        // The operator.
        ExpNode left;   // The expression for its left operand.
        ExpNode right;  // The expression for its right operand.
        BinOpNode(char op, ExpNode left, ExpNode right) {
            // Construct a BinOpNode containing the specified data.
            assert op == '+' || op == '-' || op == '*' || op == '/';
            assert left != null && right != null;
            this.op = op;
            this.left = left;
            this.right = right;
        }

        @Override
        double value(double xValue) {
            // The value is obtained by evaluating the left and right
            // operands and combining the values with the operator.
            double x = this.left.value(xValue);
            double y = this.right.value(xValue);
            switch (this.op) {
                case '+':  return x + y;
                case '-':  return x - y;
                case '*':  return x * y;
                case '/':  return x / y;
                default:   return Double.NaN;  // Bad operator!
            }
        }

        @Override
        ExpNode derivative() {
            BinOpNode BdA;
            BinOpNode AdB;
            switch (this.op) {
                case '+':  return new BinOpNode('+', this.left.derivative(), this.right.derivative());
                case '-':  return new BinOpNode('-', this.left.derivative(), this.right.derivative());
                case '*':
                    BdA = new BinOpNode('*', this.right, this.left.derivative());
                    AdB = new BinOpNode('*', this.left, this.right.derivative());
                    return new BinOpNode('+', BdA, AdB);
                case '/':
                    BdA = new BinOpNode('*', this.right, this.left.derivative());
                    AdB = new BinOpNode('*', this.left, this.right.derivative());
                    BinOpNode BB = new BinOpNode('*', this.right, this.right);
                    return new BinOpNode('/', new BinOpNode('-', BdA, AdB), BB);
                default:   return null; // 이게 의미가 있나?
            }
        }

        void  printStackCommands() {
            // To evaluate the expression on a stack machine, first do
            // whatever is necessary to evaluate the left operand, leaving
            // the answer on the stack.  Then do the same thing for the
            // second operand.  Then apply the operator (which means popping
            // the operands, applying the operator, and pushing the result).
            this.left.printStackCommands();
            this.right.printStackCommands();
            System.out.println("  Operator " + this.op);
        }

        @Override
        double derivativeValue(double xValue) {
            return derivative().value(xValue);
        }

        @Override
        void printDerivativeStackCommands(double xValue) {
            this.left.printDerivativeStackCommands(xValue);
            this.right.printDerivativeStackCommands(xValue);
            System.out.println("  Operator " + this.op);
        }

        @Override
        void printInfixExpression() {
            if (this.op == '*' || this.op == '/') {
                this.left.printInfixExpression();
                System.out.print(this.op);
                this.right.printInfixExpression();
            } else {
                System.out.print("(");
                this.left.printInfixExpression();
                System.out.print(this.op);
                this.right.printInfixExpression();
                System.out.print(")");
            }
        }

        @Override
        void printInfixExpressionSubstituted(double xValue) {
            if (this.op == '*' || this.op == '/') {
                this.left.printInfixExpressionSubstituted(xValue);
                System.out.print(this.op);
                this.right.printInfixExpressionSubstituted(xValue);
            } else {
                System.out.print("(");
                this.left.printInfixExpressionSubstituted(xValue);
                System.out.print(this.op);
                this.right.printInfixExpressionSubstituted(xValue);
                System.out.print(")");
            }
        }

        @Override
        void printInfixDerivative() {
            if (this.op == '*' || this.op == '/') {
                this.left.printInfixDerivative();
                System.out.print(this.op);
                this.right.printInfixDerivative();
            } else {
                System.out.print("(");
                this.left.printInfixDerivative();
                System.out.print(this.op);
                this.right.printInfixDerivative();
                System.out.print(")");
            }
        }

        @Override
        void printInfixDerivativeValue(double xValue) {
            if (this.op == '*' || this.op == '/') {
                this.left.printInfixDerivativeValue(xValue);
                System.out.print(this.op);
                this.right.printInfixDerivativeValue(xValue);
            } else {
                System.out.print("(");
                this.left.printInfixDerivativeValue(xValue);
                System.out.print(this.op);
                this.right.printInfixDerivativeValue(xValue);
                System.out.print(")");
            }
        }



        @Override
        public String toString() {
            return this.left.toString() + this.op + this.right.toString();
        }
    }


    /**
     * An expression node to represent a unary minus operator.
     */
    private static class UnaryMinusNode extends ExpNode {
        ExpNode operand;  // The operand to which the unary minus applies.
        UnaryMinusNode(ExpNode operand) {
            // Construct a UnaryMinusNode with the specified operand.
            assert operand != null;
            this.operand = operand;
        }

        @Override
        double value(double xValue) {
            // The value is the negative of the value of the operand.
            double neg = operand.value(xValue);
            return -neg;
        }

        void printStackCommands() {
            // To evaluate this expression on a stack machine, first do
            // whatever is necessary to evaluate the operand, leaving the
            // operand on the stack.  Then apply the unary minus (which means
            // popping the operand, negating it, and pushing the result).
            System.out.print("-");
            operand.printStackCommands();
            System.out.println("  Unary minus");
        }

        @Override
        ExpNode derivative() { // - 연산을 미분하면 -는 그대로 남으니까 괜찮지 않을까?
            return new UnaryMinusNode(this.operand.derivative());
        }

        @Override
        double derivativeValue(double xValue) {
            return derivative().value(xValue);
        }

        @Override
        void printDerivativeStackCommands(double xValue) {
            operand.printDerivativeStackCommands(xValue);
            System.out.println("  Unary minus");
        }

        @Override
        void printInfixExpression() {
            System.out.print("-" + this.operand);
        }

        @Override
        void printInfixExpressionSubstituted(double xValue) {
            System.out.print(value(xValue));
        }

        @Override
        void printInfixDerivative() {
            System.out.print(derivative());
        }

        @Override
        void printInfixDerivativeValue(double xValue) {
            System.out.print(derivativeValue(xValue));
        }


        @Override
        public String toString() {
            return "-" + this.operand.toString();
        }

    }




    //    -------------------------------------------------------------------------------


    /**
     * An object of type ParseError represents a syntax error found in
     * the user's input.
     */
    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // end nested class ParseError


    public static void main(String[] args) {

        while (true) {
            System.out.println("\n\nEnter an expression, or press return to end.");
            System.out.print("\n?  ");
            TextIO.skipBlanks();
            if ( TextIO.peek() == '\n') {
                break;
            }
            try {
                ExpNode exp = expressionTree();
                TextIO.skipBlanks();
                if ( TextIO.peek() != '\n' )
                    throw new ParseError("Extra data after end of expression.");
                TextIO.getln();
                System.out.println("Enter an x-value to insert the value into variable \"x\" (double) ");
                System.out.print("\n?  ");
                double xValue = TextIO.getDouble();

                System.out.println("-------printInfixExpression---------\n  ");
                exp.printInfixExpression();
                System.out.println("\n");
                System.out.println("x = " + xValue);



                double result = exp.value(xValue);
                System.out.println("----------------------------------");
                System.out.println("\nValue is " + result);
                System.out.println("\nOrder of postfix evaluation is:\n");
                System.out.println("-------printStackCommands---------\n");
                exp.printStackCommands();
                System.out.println("\n");

                System.out.println("-------printInfixExpressionSubstituted---------\n  ");
                exp.printInfixExpressionSubstituted(xValue);
                System.out.println("= " + result);
                System.out.println("\n");


//                System.out.println(" Derivate is ");
//                System.out.println(exp.derivative().toString());
//                System.out.println("\n");

                double derivativeResult = exp.derivativeValue(xValue);
                System.out.println("----------------------------------");
                System.out.println("\nDerivative Value is " + derivativeResult);
//                System.out.println("\nOrder of postfix evaluation is:\n");
//
//                ///////////////////////////////////////////////////////////////////////
//                System.out.println("-------printDerivativeStackCommands---------\n  ");
//                exp.printDerivativeStackCommands(xValue);
//                System.out.println("\n");
//
//                ///////////////////////////////////////////////////////////////////////
//                System.out.println("-------printInfixDerivative---------\n  ");
//                exp.printInfixDerivative();
//                System.out.println("\n");
//
//                //////////////////////////////////////////////////////////////////////
//                System.out.println("-------printInfixDerivativeValue---------\n  ");
//                exp.printInfixDerivativeValue(xValue);
//                System.out.println("\n");
//                System.out.println("----------------------------------");
//                //////////////////////////////////////////////////////////////////////

            }
            catch (ParseError e) {
                System.out.println("\n*** Error in input:    " + e.getMessage());
                System.out.println("*** Discarding input:  " + TextIO.getln());
            }
        }

        System.out.println("\n\nDone.");

    } // end main()


    /**
     * Reads an expression from the current line of input and builds
     * an expression tree that represents the expression.
     * @return an ExpNode which is a pointer to the root node of the
     *    expression tree
     * @throws ParseError if a syntax error is found in the input
     */
    private static ExpNode expressionTree() throws ParseError {
        TextIO.skipBlanks();
        boolean negative;  // True if there is a leading minus sign.
        negative = false;
        if (TextIO.peek() == '-') {
            TextIO.getAnyChar();
            negative = true;
        }
        ExpNode exp;       // The expression tree for the expression.
        exp = termTree();  // Start with the first term.
        if (negative)
            exp = new UnaryMinusNode(exp);
        TextIO.skipBlanks();
        while ( TextIO.peek() == '+' || TextIO.peek() == '-' ) {
            // Read the next term and combine it with the
            // previous terms into a bigger expression tree.
            char op = TextIO.getAnyChar();
            ExpNode nextTerm = termTree();
            exp = new BinOpNode(op, exp, nextTerm);
            TextIO.skipBlanks();
        }
        return exp;
    } // end expressionTree()


    /**
     * Reads a term from the current line of input and builds
     * an expression tree that represents the expression.
     * @return an ExpNode which is a pointer to the root node of the
     *    expression tree
     * @throws ParseError if a syntax error is found in the input
     */
    private static ExpNode termTree() throws ParseError {
        TextIO.skipBlanks();
        ExpNode term;  // The expression tree representing the term.
        term = factorTree();
        TextIO.skipBlanks();
        while ( TextIO.peek() == '*' || TextIO.peek() == '/' ) {
            // Read the next factor, and combine it with the
            // previous factors into a bigger expression tree.
            char op = TextIO.getAnyChar();
            ExpNode nextFactor = factorTree();
            term = new BinOpNode(op,term,nextFactor);
            TextIO.skipBlanks();
        }
        return term;
    } // end termValue()


    /**
     * Reads a factor from the current line of input and builds
     * an expression tree that represents the expression.
     * @return an ExpNode which is a pointer to the root node of the
     *    expression tree
     * @throws ParseError if a syntax error is found in the input
     */
    private static ExpNode factorTree() throws ParseError {
        TextIO.skipBlanks();
        char ch = TextIO.peek();
        if ( Character.isDigit(ch) ) {
            // The factor is a number.  Return a ConstNode.
            double num = TextIO.getDouble();
            return new ConstNode(num);
        } else if (Character.isAlphabetic(ch)) {
            // The factor is a x-variable. Return a VariableNode.
            TextIO.getAnyChar();
            return new VariableNode();
        }
        else if ( ch == '(' ) {
            // The factor is an expression in parentheses.
            // Return a tree representing that expression.
            TextIO.getAnyChar();  // Read the "("
            ExpNode exp = expressionTree();
            TextIO.skipBlanks();
            if ( TextIO.peek() != ')' )
                throw new ParseError("Missing right parenthesis.");
            TextIO.getAnyChar();  // Read the ")"
            return exp;
        }
        else if ( ch == '\n' )
            throw new ParseError("End-of-line encountered in the middle of an expression.");
        else if ( ch == ')' )
            throw new ParseError("Extra right parenthesis.");
        else if ( ch == '+' || ch == '-' || ch == '*' || ch == '/' )
            throw new ParseError("Misplaced operator.");
        else
            throw new ParseError("Unexpected character \"" + ch + "\" encountered.");
    }  // end factorTree()
} // end class SimpleParser3
