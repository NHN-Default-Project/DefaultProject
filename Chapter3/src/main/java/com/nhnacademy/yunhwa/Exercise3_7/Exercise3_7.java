package com.nhnacademy.yunhwa.Exercise3_7;

public class Exercise3_7 {
    // 참고 예제 : 생일이 같은 2명의 사람을 찾으려면 랜덤으로 몇 명의 사람을 선택해야 하나요?

    // 1. 생일이 같은 3명의 사람을 찾으려면 랜덤으로 몇 명을 선택해야 하나요?
    // 2. 랜덤으로 365명을 선택한다고 가정해보면, 그들의 생일은 몇 개나 될까요? (숫자는 1 ~ 365 사이)
    // 3. 1년 365일 생일이 있는 사람을 최소한 한 명씩 찾으려면 얼마나 많은 사람을 확인해야 합니까?
    public static void main(String[] args) {
        System.out.println();
        System.out.format("생일이 같은 세 사람을 찾기 위해서는 랜덤으로 총 %d 명을 선택해야 합니다.\n", findThreeOfSameBirthday());
        
        System.out.println();
        System.out.format("랜덤으로 365명을 선택했다고 가정했을 때, 총 365개의 날짜 중 그들의 생일은 총 %d 개 입니다.\n", howManyBirthdayOf365People(365));
        System.out.println();
        
        System.out.format("1년 365일 생일이 있는 사람을 최소한 한 명씩 찾기 위해 확인해야하는 사람 수는 %d 입니다.\n", countForFillAllBirthdayOfAnYear());
        System.out.println();
    }

    public static boolean isExistedBirthday(int birthday, boolean[] used) {
        if (used[birthday]) return true;
        else return false;
    }

    public static boolean isAllBirthdayExist(boolean[] used) {
        for (int i = 1; i < used.length; i++) {
            if(! used[i]) return false;
        }

        return true;
    }

    public static int findThreeOfSameBirthday() {

        // 1. 생일이 같은 3명의 사람을 찾으려면 랜덤으로 몇 명을 선택해야 하나요?
        boolean[] used = new boolean[365+1];

        int randomPeopleCount = 0;
        int duplicatedCount = 0;

        while (true) {
            int birthday = (int) (Math.random() * 365) + 1;
            randomPeopleCount++;

            if (used[birthday]) {
                if (duplicatedCount == 3) {
                    break;
                } else {
                    duplicatedCount++;
                }
            } else {
                used[birthday] = true;
                duplicatedCount = 1;
            }
        }

        return randomPeopleCount;
    }

    public static int howManyBirthdayOf365People(int peopleNumber) {
        // 2. 랜덤으로 365명을 선택한다고 가정해보면, 그들의 생일은 몇 개나 될까요? (숫자는 1 ~ 365 사이)
        
        // 초기화
        boolean[] used = new boolean[365+1]; 

         // 365명의 사람 생성
        int[] birthdaysOfPeople = new int[peopleNumber];

        for (int i = 0; i < 365; i++) {
            birthdaysOfPeople[i] = (int) (Math.random() * peopleNumber) + 1;;
            used[birthdaysOfPeople[i]] = true;
        }

        int birthdayCount = 0;
        for (int i = 1; i < used.length; i++) {
            if (used[i]) {
                birthdayCount++;
            }
        }

        if (birthdayCount < 1 || birthdayCount > 365) {
            System.out.println("개수가 잘못되었습니다. 문제를 다시 풀어보세요.");
        }

        return birthdayCount;
    }

    public static int countForFillAllBirthdayOfAnYear() {
        // 3. 1년 365일 생일이 있는 사람을 최소한 한 명씩 찾으려면 얼마나 많은 사람을 확인해야 합니까?

        // 초기화
        boolean[] used = new boolean[365+1]; 
        int randomPeopleCount = 0;

        while (! isAllBirthdayExist(used)) {
            int birthday = (int) (Math.random() * 365) + 1;;
            randomPeopleCount++;

            if(!isExistedBirthday(birthday, used)) {
                used[birthday] = true;
            }

        }

        return randomPeopleCount;
    }


}
