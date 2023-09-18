package com.nhnacademy.gaeun.exercise07;

/**
 * Simulate choosing people at random and checking the day of the year they
 * were born on. If the birthday is the same as one that was seen previously,
 * stop, and output the number of people who were checked.
 */
public class BirthdayProblem {

    public static void main(String[] args) {
        findThreePerson();
        howManyPeople();
        allFilled();
    }

    public static void findThreePerson() {
        boolean[] used;
        int count = 0;
        int tmp = 0;
        used = new boolean[365];

        while (true) {
            int birthday;
            birthday = (int) (Math.random() * 365);
            count++;
            System.out.printf("Person %d has birthday number %d%n", count, birthday);
            if (used[birthday]) {
                tmp++;
                if (tmp == 2){
                    break;
                }
            }
            used[birthday] = true;
        }

        System.out.println();
        System.out.println("A duplicate birthday was found after "
                + count + " tries.");
    }

    public static void howManyPeople() {
        boolean[] used;
        int count = 0;
        int birthday;
        used = new boolean[365];

        for(int i = 0; i < 365; i++) {
            birthday = (int) (Math.random() * 365);
            used[birthday] = true;
        }

        for(int i = 0; i < 365; i++) {
            if(used[i])count++;
        }

        System.out.println();
        System.out.println("무작위로 365명을 선택한 경우: " + count + "개의 생일 존재");
    }

    public static void allFilled() {
        boolean[] used;
        int count = 0;
        int tmp = 0;
        used = new boolean[365];
        int index = 0;

        while (true) {
            int birthday;
            birthday = (int) (Math.random() * 365);
            count++;
            if(used[index]){
                index++;
                if(index >= 365){
                    break;
                }
            }
            used[birthday] = true;
        }

        System.out.println();
        System.out.println("A duplicate birthday was found after " + count + " tries.");
    }

} // end class BirthdayProblem