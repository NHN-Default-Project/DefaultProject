package com.nhnacademy.yunhwa.Exercise4_5;

import java.util.Scanner;

public class Exercise4_5 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("-------------------------------------------------");
            System.out.print("만들려는 double 형 배열의 크기를 입력해주세요 : ");
            int arraySize = Integer.valueOf(sc.nextLine());

            if (arraySize <= 0) {
                throw new IllegalArgumentException("배열의 크기를 0 이하로 잘못 기입하셨습니다. 다시 1 이상의 값으로 기입해주세요");
            }

            double[] array = new double[arraySize];

            System.out.println("\n아래 입력 형식 예시들을 참고하여\n double 형 배열을 만들 double 값들을 입력해주세요.");
            System.out.println("-------------------------------------------------");
            System.out.println("참고) 입력 형식 예시 1: { 3.1, 4.6, 5.1, 6.9, 7.0 }");
            System.out.println("참고) 입력 형식 예시 2: { 3.1  4.6  5.1  6.9  7.0 }");
            System.out.println("참고) 입력 형식 예시 3:   3.1  4.6  5.1  6.9  7.0 ");
            System.out.println("참고) 입력 형식 예시 4:   3.1, 4.6, 5.1, 6.9, 7.0");
            System.out.println("이렇게 중괄호를 쓰시는 건 자유입니다. 다만 꼭 1개 이상의 공백 또는 ','로 구분해서 입력해주세요");
            System.out.print(": ");

            String tmpStr = sc.nextLine();
            char[] tmpCharArray = tmpStr.toCharArray();

            int arrayIndex = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < tmpCharArray.length; i++) {
                char character = tmpCharArray[i];

                if (character == '{' || character == ',' || character == ' ' || character == '}' || i == tmpCharArray.length-1) {
                    if (sb.length() != 0) {
                        // 마지막 값인데 문자라면, 여기까지 포함시키기
                        if (i == tmpCharArray.length-1) {
                            sb.append(character);
                        }
                        // 이전까지는 double 값이었다는 것 -> 만들어진 값을 double 배열에 넣기
                        array[arrayIndex++] = Double.valueOf(sb.toString());
                        sb.setLength(0); // string builder 초기화
                    }
                } else if (character == '.' || character >= '0' && character <= '9') {
                    sb.append(character);
                }
            }

            System.out.println("-------  해당 배열의 연산 결과값들  --------");
            
            System.out.format("배열 요소들의 최댓값 : %.1f\n", ArrayProcessors.maximumOfArray.apply(array));
            System.out.format("배열 요소들의 최솟값 : %.1f\n", ArrayProcessors.minimumOfArray.apply(array));
            System.out.format("배열 요소들의 합 : %.1f\n", ArrayProcessors.sumOfArray.apply(array));
            System.out.format("배열 요소들의 평균 값 : %.2f\n", ArrayProcessors.averageOfArray.apply(array));

            System.out.print("배열 안에 몇 개가 있는지 궁금한 타겟 값(double)을 입력해주세요 : ");
            String tmpValue = sc.nextLine().trim();
            double value = Double.valueOf(tmpValue);

            // try {
            //     value = Double.valueOf(tmpValue);
            // } catch (IllegalFormatConversionException e) {
            //     value = (double) Integer.valueOf(tmpValue); // 강제 형변환 (.0 으로)
            // }

            System.out.format("배열에 존재하는 %f 값의 개수 : %.0f 개\n", value, ArrayProcessors.counter(value).apply(array));
            
        }
    }
}