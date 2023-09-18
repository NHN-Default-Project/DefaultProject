package com.nhnacademy.gaeun.exercise01;

// 연습 3.1:
// 뱀의 눈이 나올 때까지 주사위를 몇 번이나 굴려야 합니까? 
// 주사위를 손으로 굴려 실험을 할 수 있습니다. 실험을 시뮬레이션하는 컴퓨터 프로그램을 작성하세요. 
// 프로그램은 주사위가 뱀의 눈으로 나오기 전에 굴린 횟수를 보고해야 합니다. 
// (참고: "뱀 눈"은 두 주사위 모두 1의 값을 나타냄을 의미합니다.) 
// 연습 2.2에서는 한 쌍의 주사위 굴리기를 시뮬레이션하는 방법을 설명했습니다.

public class Main {
    public static void main(String[] args) {
        int count = 0;
        while(true){
            if(dice() == 1 && dice() == 1){
                break;
            }
            count++;
        }
        System.out.println(count);
    }

    public static int dice() {
        return (int)(Math.random() * 6) + 1;
    }
}