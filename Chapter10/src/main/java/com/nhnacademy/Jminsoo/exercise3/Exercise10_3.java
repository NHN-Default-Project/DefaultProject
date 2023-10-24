package com.nhnacademy.Jminsoo.exercise3;

import java.io.IOException;

public class Exercise10_3 {

    public static void main(String[] args) {
        try {
            MyInterpreter interpreter = new MyInterpreter();
            interpreter.run();
        } catch (IOException e) {
            System.out.println("버퍼리더에 이상이 있습니다.");
        }
    }
}
