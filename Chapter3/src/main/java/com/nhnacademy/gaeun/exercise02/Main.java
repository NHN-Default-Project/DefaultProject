package com.nhnacademy.gaeun.exercise02;

// 연습 3.2:
// 1에서 10000 사이에서 제수가 가장 많은 정수는 무엇이며, 제수는 몇 개입니까? 
// 답을 구하고 결과를 출력하는 프로그램을 작성하세요. 이 범위의 여러 정수가 동일한 최대공약수를 가질 수 있습니다. 
// 귀하의 프로그램은 그 중 하나만 인쇄하면 됩니다. 하위 섹션 3.4.2 의 예에서는 제수에 대해 논의했습니다. 
// 해당 예제의 소스 코드는 CountDivisors.java 입니다 .

// 최대값을 찾는 방법에 대한 힌트가 필요할 수 있습니다. 기본 아이디어는 지금까지 본 가장 큰 수의 제수를 추적하면서 
// 모든 정수를 살펴보는 것입니다 . 또한 해당 수의 제수가 있는 정수를 추적하세요.

public class Main {
    public static void main(String[] args) {
        int max = 0;
        for(int i = 1; i <= 10000; i++) {
            if(max < divisor(i)){
                max = divisor(i);
            }
        }
        System.out.println(max);
    }
    public static int divisor(int number) {
        int count = 0;
        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                count++;
            }
        }
        return count;
    }
    
}