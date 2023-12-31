package com.nhnacademy.Jminsoo.exercise7;


public class StandardFunction {
    Functions functionCode;

    enum Functions {
        SIN, COS, TAN, ABS, SQRT, LOG, PI, E

    }

    StandardFunction(Functions code) {
        this.functionCode = code;
    }


    public double evaluate(double x) {
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
            case E:
                return Math.E;
            case PI:
                return Math.PI;
            default:
                return Math.log(x);
        }
    }
}


