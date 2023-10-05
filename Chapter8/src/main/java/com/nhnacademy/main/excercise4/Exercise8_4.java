package com.nhnacademy.main.excercise4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise8_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> inputXList = new ArrayList<>();
        boolean isContinue = true;

        while (isContinue) {
            try {
                System.out.print("표현식에 대입할 (double) x 값을 추가해주세요 (0 입력시 x 리스트 생성 완료됨) : ");
                double x = sc.nextDouble();
                if (x == 0.0) {
                    isContinue = false;
                }
                inputXList.add(x);
            } catch (NoSuchElementException | IllegalArgumentException e) {
                System.out.println("double 값으로 변환할 수 없는 값이 입력되었습니다. 다시 입력해주세요!");
            }
        }

        isContinue = true;
        System.out.println("값이 다 입력이 완료되었습니다.");
        sc.nextLine();

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

        sc.close();
    }
}

