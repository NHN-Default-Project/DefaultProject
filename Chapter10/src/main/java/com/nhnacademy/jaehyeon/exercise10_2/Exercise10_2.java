package com.nhnacademy.jaehyeon.exercise10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://math.hws.edu/javanotes/c10/exercises.html
 * 사용자로부터 입력을 받아 음수가 아닌 정수 집합을 나타내는 두 개의 TreeSet을 생성합니다.
 * 입력을 파싱하고 입력 오류를 처리합니다.
 * 입력된 연산자 (+, *, -)에 따라 해당 연산을 수행하고 결과를 출력합니다.
 * 프로그램은 여러 입력 라인을 처리하며 구문 오류가 발생하면 오류를 보고하고 다음 입력 라인으로 이동합니다.
 * 프로그램은 Java를 사용하여 Set 인터페이스의 메서드를 활용하여 합집합, 교집합 및 차이 연산을 수행합니다. 사용자가 요청한 연산에 따라 결과 집합을 생성하고 출력합니다.
 */
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
