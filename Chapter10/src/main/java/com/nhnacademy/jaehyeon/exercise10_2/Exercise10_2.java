package com.nhnacademy.jaehyeon.exercise10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//음수정수 허용 x
//입력, 출력 될때 정수 집합은 쉼표로 구분하고 공백과 대괄호로 둘러쌓여있음
// + 일때 합집합
// * 일때 교집합
// - 일때 차집합
public class Exercise10_2 {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String expression = inputString(br);

            ExpressionProcessing expressionProcessing = new ExpressionProcessing(expression);
            SetCalculate setCalculate = new SetCalculate(expressionProcessing);
            System.out.println(setCalculate);


        } catch (IOException e) {

        }
    }

    public static String inputString(BufferedReader br) throws IOException {
        String inputExpression;
        while (true) {
            try {
                inputExpression = br.readLine();
                verify(inputExpression);
                break;
            } catch (NotMatchExpression e) {
                System.out.println(e.getMessage());
            }
        }
        return inputExpression;
    }

    public static void verify(String inputStr) throws NotMatchExpression {
        String regex =
                "\\[\\s*\\d+\\s*(,\\s*\\d+\\s*)*\\]\\s*[+*-]\\s*\\[\\s*\\d+\\s*(,\\s*\\d+\\s*)*\\]"; //이거에 관한건 Main에 있습니다.

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        if (!matcher.matches()) {
            throw new NotMatchExpression("올바른 표현식을 입력하세요 ");
        }
    }
}
