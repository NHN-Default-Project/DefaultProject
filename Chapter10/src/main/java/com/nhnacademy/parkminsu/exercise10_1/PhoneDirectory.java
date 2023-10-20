package com.nhnacademy.parkminsu.exercise10_1;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PhoneDirectory는 각 이름에 대한 전화번호 목록을 관리하는 클래스입니다.
 * 특정 이름에 대한 전화번호를 찾거나, 주어진 이름에 대한 전화번호를 지정하는 것이 가능합니다.
 */
public class PhoneDirectory {


    private final Map<String, String> nameAndNumberDataMap;

    /**
     * 생성자는 초기에 비어 있는 전화번호 목록을 만듭니다.
     */
    public PhoneDirectory() {
        nameAndNumberDataMap = new TreeMap<>();
    }


    /**
     * 입력 값이 빈 값이면 Exception을 던집니다.
     * 주어진 이름에 대한 전화번호를 찾습니다. 이름이 전화번호 목록에 존재하지 않으면 반환 값은 null입니다.
     *
     * @return 이름과 연결된 전화번호; 이름이 전화번호 목록에 존재하지 않는 경우 Exception을 던집니다.
     */
    public String getNumber(String name) throws EmptyDataException {

        // 주어진 이름에 대한 전화번호 항목이 없습니다.
        isCheckEmpty(name);
        String number = this.nameAndNumberDataMap.getOrDefault(name, null);
        if (Objects.isNull(number)) {
            throw new NullPointerException("해당 값의 데이터가 없습니다");
        }
        return number;
    }

    /**
     * 주어진 이름을 주어진 전화번호와 연결합니다. 이미 이름이 전화번호 목록에 있는 경우 새 번호가 이전 번호를 대체합니다.
     * 그렇지 않은 경우 새로운 이름/전화번호 쌍이 추가됩니다. 이름과 번호는 모두 null이 아니어야 합니다.
     * 이러한 경우가 아닌 경우 IllegalArgumentException이 throw됩니다.
     */
    public void putNumber(String name, String number) throws DataEntryFormatException {
        isCheckNameData(name);
        isCheckNumberData(number);
        if (name == null && number == null) {
            throw new IllegalArgumentException("이름 또는 번호의 값이 null입니다");
        }
        this.nameAndNumberDataMap.put(name, number);

    }

    /**
     * 사용자가 형식에 맞춰서 입력했는지 확인
     */
    public void isCheckNameData(String inputData) throws DataEntryFormatException {
        Pattern pattern = Pattern.compile("^[a-zA-Z가-힣]*$");
        Matcher matcher = pattern.matcher(inputData);

        if (!isDataEntryFormat(matcher)) {
            throw new DataEntryFormatException("이름을 잘못 입력하셨습니다.");
        }
    }

    public void isCheckNumberData(String inputData) throws DataEntryFormatException {
        Pattern pattern = Pattern.compile("(01[01678]\\-\\d{3,4}\\-\\d{4})*$");
        Matcher matcher = pattern.matcher(inputData);

        if (!isDataEntryFormat(matcher)) {
            throw new DataEntryFormatException("전화번호를 잘못 입력하셨습니다.");
        }
    }

    public boolean isDataEntryFormat(Matcher matcher) {
        return matcher.find();
    }

    public void isCheckEmpty(String data) throws EmptyDataException {
        if (isEmpty(data)) {
            throw new EmptyDataException("빈 값을 입력하셨습니다");
        }
    }

    public boolean isEmpty(String data) {
        return data.isEmpty();
    }


} // PhoneDirectory 클래스 마침
