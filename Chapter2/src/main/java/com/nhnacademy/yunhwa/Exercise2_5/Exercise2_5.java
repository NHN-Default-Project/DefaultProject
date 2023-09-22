package com.nhnacademy.yunhwa.Exercise2_5;

public class Exercise2_5 {
    // 정수 N에 대해, N 개의 계란이 있다면 N / 12 개의 계란이 있고, N % 12 의 계란이 남습니다.
    // 사용자에게 달걀이 몇 개 있는지 묻고, 사용자에게 달걀이 몇 다스인지, 남은 달걀이 몇 개 있는지 알려주는 프로그램

    public static void main(String[] args) {

        System.out.print("당신은 몇 개의 달걀을 가지고 있습니까? 개수를 적어주세요 : ");
        int eggCount = TextIO.getlnInt();

        Eggs grossOfEggs = howManyGross(eggCount);
        Eggs dozenOfEggs = howManyDozen(grossOfEggs.getLeftEggs());

        System.out.print("계란 수는 총 " + grossOfEggs.getBundle() + " gross, ");
        System.out.print(dozenOfEggs.getBundle() + " dozen, ");
        System.out.println("and " + dozenOfEggs.getLeftEggs());

    }

    public static Eggs howManyBundle(int eggCount, int standard) {
        int bundle = eggCount / standard;
        int leftEggs = eggCount % standard;

        return new Eggs(bundle, leftEggs);
    }

    // 달걀수 인자로 받아서 더즌 수, 남은 달걀 수 배열로 리턴하기
    public static Eggs howManyDozen(int eggCount) {
        return howManyBundle(eggCount, 12);
    }

    public static Eggs howManyGross(int eggCount) {
        return howManyBundle(eggCount, 144);
    }
}
