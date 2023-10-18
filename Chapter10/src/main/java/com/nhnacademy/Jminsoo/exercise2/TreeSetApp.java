package com.nhnacademy.Jminsoo.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeSetApp {

    public void readUserInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputStr = br.readLine();

            String firstSetStr = inputStr.substring(inputStr.indexOf("[") + 1, inputStr.indexOf("]"));
            String[] firstSetStrArray = firstSetStr.split(",");

            for (String str : firstSetStrArray)

        } catch (IOException e) {

        }
    }

    private String[]

}
