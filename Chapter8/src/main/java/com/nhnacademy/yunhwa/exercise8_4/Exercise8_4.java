package com.nhnacademy.yunhwa.exercise8_4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise8_4 {

    // 예제 수행 프로그램 main 메서드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Expr expression = makeExpression(sc);
        List<Double> xList = makeXList(sc);
        printResult(expression, xList);

        sc.close();
    }



    // 사용자로부터 표현식 입력받아 Expr 객체 만드는 메서드
    public static Expr makeExpression(Scanner sc) {
        Expr func;
        while (true) {
            try {
                System.out.print("표현식을 입력해주세요 : ");

                String def = sc.nextLine().trim();
                func = new Expr(def);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return func;
    }



    // 사용자로부터 표현식에 대입할 x 값들 여러 개 입력받고 xList 완성하는 메서드
    public static List<Double> makeXList(Scanner sc) {
        List<Double> xList = new ArrayList<>();
        while (true) {
            try {
                System.out.print("표현식에 대입할 (double) x 값을 추가해주세요 (0 입력시 x 리스트 생성 완료됨) : ");

                double x = sc.nextDouble();
                if (x == 0.0) {
                    break;
                }
                xList.add(x);
            } catch (NoSuchElementException e) {
                System.out.println("double 값으로 변환할 수 없는 값이 입력되었습니다. 다시 입력해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                sc = new Scanner(System.in);
            } // InputMismatchException 은 NoSuchElementException 의 하위 타입 이라 위에서 잡혀서 처리 안해도 됨.
        }
        return xList;
    }


    // 표현식에 대입한 결과들 출력하는 메서드
    public static void printResult(Expr expression, List<Double> xList) {
        for (double x : xList) {
            System.out.printf("[%s] 에 x=%.3f 넣어 계산한 결과 : %.3f %n", expression, x, expression.value(x));
        }
    }



}

