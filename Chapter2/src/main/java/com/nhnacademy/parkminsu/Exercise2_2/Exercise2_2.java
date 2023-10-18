package com.nhnacademy.parkminsu.Exercise2_2;

import com.nhnacademy.parkminsu.Exercise2_2.exception.NegativeNumException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2_2 {
    public static void main(String[] args) {
        int diceEye = 0;
        int diceNum = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("주사위의 눈 갯수를 입력하세요");
            diceEye = inputDiceData(br);
            System.out.println("굴릴 주사위의 갯수를 입력하세요");
            diceNum = inputDiceData(br);
            DiceApp diceApp = new DiceApp(diceEye, diceNum);
            diceApp.rollDices();
            System.out.println(diceApp.sum());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NegativeNumException e) {
            System.out.println(e.getMessage());
        }


    }

    public static int inputDiceData(BufferedReader bufferedReader) throws IOException, NegativeNumException {
        String inputData = bufferedReader.readLine();
        if (checkNegativeNum(Integer.parseInt(inputData))) {
            throw new NegativeNumException("주사위 갯수를 음수로 입력하셨습니다.");
        }
        return Integer.parseInt(inputData);
    }

    public static boolean checkNegativeNum(int num) {
        return num < 0;
    }

}
