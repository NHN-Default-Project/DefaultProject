package com.nhnacademy.parkminsu.exercise10_1;

import java.util.Map;
import java.util.TreeMap;

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
     * 주어진 이름에 대한 전화번호를 찾습니다. 이름이 전화번호 목록에 존재하지 않으면 반환 값은 null입니다.
     *
     * @return 이름과 연결된 전화번호; 이름이 전화번호 목록에 존재하지 않는 경우 반환 값은 null입니다.
     */
    public String getNumber(String name) {
        // 주어진 이름에 대한 전화번호 항목이 없습니다.
        return this.nameAndNumberDataMap.getOrDefault(name, null);
    }

    /**
     * 주어진 이름을 주어진 전화번호와 연결합니다. 이미 이름이 전화번호 목록에 있는 경우 새 번호가 이전 번호를 대체합니다.
     * 그렇지 않은 경우 새로운 이름/전화번호 쌍이 추가됩니다. 이름과 번호는 모두 null이 아니어야 합니다.
     * 이러한 경우가 아닌 경우 IllegalArgumentException이 throw됩니다.
     */
    public void putNumber(String name, String number) {
        if (name == null && number == null) {
            throw new IllegalArgumentException("이름 또는 번호의 값이 null입니다");
        }
        this.nameAndNumberDataMap.put(name, number);

    }

} // PhoneDirectory 클래스 마침
