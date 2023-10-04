package com.nhnacademy.yunhwa.exercise8_4;

import java.util.*;

public class Exercise8_4 {
    public static void main(String[] args) {
        List<Double> xList = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in);) {

            while (true) {
                System.out.print("표현식에 대입할 (double) x 값을 추가해주세요 (0 입력시 x 리스트 생성 완료됨) : ");
                double x = sc.nextDouble();
                if (x == 0.0) {
                    break;
                }
                xList.add(x);
            }

            System.out.println("값이 다 입력이 완료되었습니다.");
            System.out.print("이제 표현식을 입력해주세요 : ");
            sc.nextLine();
            String def = sc.nextLine().trim();
            Expr func = new Expr(def);

            for (double x : xList) {
                System.out.printf("%s 에 %.3f 넣어 계산한 결과 : %.3f %n", def, x, func.value(x));
            }

        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }// InputMismatchException 은 NoSuchElementException 의 하위 타입 이라 위에서 잡혀서 처리 안해도 됨.
    }
}
