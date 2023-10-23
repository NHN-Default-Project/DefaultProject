package com.nhnacademy.yunhwa.exercise10_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* 10 - 1
 * 하위 섹션 7.5.2 의 PhoneDirectory 클래스 다시 작성
 * 기존 : 배열 활용 -> 변경 : TreeMap 활용 (디렉토리 엔트리 들 저장하는데 사용)  (섹션 10.3.1에서 제안된 것임)
 * 클래스를 테스트하기 위한 짧은 프로그램도 작성
 * */
public class Exercise10_1 {


    @Test
    @DisplayName("print Test")
    void printTest() {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.putNameAndPhoneNumber("John Doe", "123-456-7890");
        phoneDirectory.putNameAndPhoneNumber("Jane Smith", "987-654-3210");
        phoneDirectory.putNameAndPhoneNumber("David Johnson", "555-123-4567");
        phoneDirectory.putNameAndPhoneNumber("Emily Davis", "111-222-3333");
        phoneDirectory.putNameAndPhoneNumber("Michael Wilson", "444-555-6666");
        phoneDirectory.putNameAndPhoneNumber("Sarah Thompson", "010-777-8888");
        phoneDirectory.putNameAndPhoneNumber("Robert Anderson", "010-9999-0000");
        phoneDirectory.putNameAndPhoneNumber("Jessica Martinez", "111-222-3333");
        phoneDirectory.putNameAndPhoneNumber("Daniel Rodriguez", "444-555-6666");
        phoneDirectory.putNameAndPhoneNumber("Jennifer Lee", "777-888-9999");
        phoneDirectory.putNameAndPhoneNumber("Kim Ji Un", "010-1234-5678");
        phoneDirectory.putNameAndPhoneNumber("Angela Merkel", "010-2345-6789");
        phoneDirectory.putNameAndPhoneNumber("Vladimir Putin", "010-3456-7890");
        phoneDirectory.putNameAndPhoneNumber("Emmanuel Macron", "010-4567-8901");
        phoneDirectory.putNameAndPhoneNumber("Justin Trudeau", "010-5678-9012");

        System.out.println(phoneDirectory);
    }

    @Test
    @DisplayName("getPhoneNumber Test")
    void getPhoneNumberTest() {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.putNameAndPhoneNumber("John Doe", "123-456-7890");
        phoneDirectory.putNameAndPhoneNumber("Jane Smith", "987-654-3210");
        phoneDirectory.putNameAndPhoneNumber("David Johnson", "555-123-4567");
        phoneDirectory.putNameAndPhoneNumber("Emily Davis", "111-222-3333");
        phoneDirectory.putNameAndPhoneNumber("Michael Wilson", "444-555-6666");
        phoneDirectory.putNameAndPhoneNumber("Sarah Thompson", "010-777-8888");
        phoneDirectory.putNameAndPhoneNumber("Robert Anderson", "010-9999-0000");
        phoneDirectory.putNameAndPhoneNumber("Jessica Martinez", "111-222-3333");
        phoneDirectory.putNameAndPhoneNumber("Daniel Rodriguez", "444-555-6666");
        phoneDirectory.putNameAndPhoneNumber("Jennifer Lee", "777-888-9999");
        phoneDirectory.putNameAndPhoneNumber("Kim Ji Un", "010-1234-5678");
        phoneDirectory.putNameAndPhoneNumber("Angela Merkel", "010-2345-6789");
        phoneDirectory.putNameAndPhoneNumber("Vladimir Putin", "010-3456-7890");
        phoneDirectory.putNameAndPhoneNumber("Emmanuel Macron", "010-4567-8901");
        phoneDirectory.putNameAndPhoneNumber("Justin Trudeau", "010-5678-9012");

        Assertions.assertTrue(phoneDirectory.getData().entrySet().stream()
                .map(entry -> phoneDirectory.getPhoneNumber(entry.getKey())
                        .equals(entry.getValue()))
                .filter(bool -> bool.equals(true))
                .count()
                == phoneDirectory.getData().size());
    }

}
