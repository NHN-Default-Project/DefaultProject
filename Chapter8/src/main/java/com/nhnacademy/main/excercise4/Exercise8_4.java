package com.nhnacademy.main.excercise4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise8_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> inputXList;
        boolean isContinue = true;
        String answer = "";


        while (isContinue) {
            //x값 입력
            inputXList = inputxlist(sc);
            //expression 입력 및 출력
            inputExpression(sc, inputXList);

            //반복여부
            while (isContinue) {
                try {
                    System.out.print("계속 하시겠습니까? (y/n) : ");
                    answer = sc.nextLine().trim().toLowerCase();
                    if (answer.equals("n") || answer.equals("y")) {
                        break;
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (answer.equals("n")) {
                isContinue = false;
            }
        }

        sc.close();
    }

    public static List<Double> inputxlist(Scanner sc) {
        boolean isContinue = true;
        List<Double> result = new ArrayList<>();

        while (isContinue) {
            try {
                System.out.print("표현식에 대입할 (double) x 값을 추가해주세요 (0 입력시 x 리스트 생성 완료됨) : ");
                double x = sc.nextDouble();
                if (x == 0.0) {
                    isContinue = false;
                } else {
                    result.add(x);
                }
            } catch (NoSuchElementException | IllegalArgumentException e) {
                System.out.println("double 값으로 변환할 수 없는 값이 입력되었습니다. 다시 입력해주세요!");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return result;
    }

    public static void inputExpression(Scanner sc, List<Double> inputXList) {
        boolean isContinue = true;

        while (isContinue) {
            try {
                System.out.print("이제 표현식을 입력해주세요 : ");

                String def = sc.nextLine().trim();
                Expr func = new Expr(def);

                for (double x : inputXList) {
                    System.out.printf("[%s] 에 x=%.3f 넣어 계산한 결과 : %.3f %n", def, x, func.value(x));
                }
                isContinue = false;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

