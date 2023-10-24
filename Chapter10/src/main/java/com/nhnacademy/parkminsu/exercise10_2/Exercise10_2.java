package com.nhnacademy.parkminsu.exercise10_2;

import com.nhnacademy.parkminsu.exercise10_2.exception.ExpressionEntryFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Exercise10_2 {
    // 입력 값: [1,2,3] + [2,5] -> [1,2,3,5]

    public static void main(String[] args) {
        String inputData = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("집합과 연산자를 입력해주세요(예시. [1,3] + [2]+[3]");
            inputData = br.readLine().trim().replace(" ", ""); // 값 입력

            Expression expression = new Expression(inputData);
            CalculatorSetExpressions calculatorSetExpression = new CalculatorSetExpressions();

            Set<String> result = calculatorSetExpression.calculate(expression);

            System.out.println("수식 결과: " + result);

        } catch (IOException | ExpressionEntryFormatException e) {
            System.out.println(e.getMessage());
        }
    }


}
