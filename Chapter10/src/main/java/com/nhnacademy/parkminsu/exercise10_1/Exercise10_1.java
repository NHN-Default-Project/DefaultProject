package com.nhnacademy.parkminsu.exercise10_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise10_1 {

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        String inputData = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("전화목록에 넣을 이름과 번호를 입력해주세요(이름과 전화번호 사이에는 공백으로 구분해주세요)");
            System.out.println("예시: parkminsu 010-1234-1234");
            inputData = br.readLine().trim();
            isCheckDataEntryFormat(inputData); // 입력한 형식에 어긋나면 예외처리
            String[] nameAndNumberData = inputData.split(" ");
            phoneDirectory.putNumber(nameAndNumberData[0], nameAndNumberData[1]);
            System.out.println("번호를 찾을 사람을 입력하세요");
            String name = br.readLine();
            System.out.println("검색 결과: " + phoneDirectory.getNumber(name));

            System.out.println("잘못된 값입력 테스트");
            phoneDirectory.putNumber("asd", "25");
        } catch (IOException | DataEntryFormatException | EmptyDataException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 사용자가 형식에 맞춰서 입력했는지 확인
     */
    public static void isCheckDataEntryFormat(String inputData) throws DataEntryFormatException {
        Pattern pattern = Pattern.compile("^[a-zA-Z가-힣]* (01[016789]\\-\\d{3,4}\\-\\d{4})*$");
        Matcher matcher = pattern.matcher(inputData);
        if (!isDataEntryFormat(matcher)) {
            throw new DataEntryFormatException("데이터 형식을 맞추지 않았습니다.");
        }
    }

    public static boolean isDataEntryFormat(Matcher matcher) {
        return matcher.find();
    }

}
