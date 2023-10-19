package com.nhnacademy.jaehyeon.exercise10_3;

/*
 * https://math.hws.edu/javanotes/c10/exercises.html
 * Java에서 처음부터 해시 테이블을 구현하며, 키와 값이 String 유형입니다.
 * get(key), put(key, value), remove(key), containsKey(key), 및 size() 메서드를 구현합니다.
 * 연결 목록을 사용하여 내부 데이터 구조를 만들며, 테이블 크기를 동적으로 조정할 필요는 없습니다.
 * 솔루션을 테스트하기 위한 짧은 프로그램을 작성합니다.
 */
public class Exercise10_3 {
    public static void main(String[] args) {
        HaspMapCustom haspMapCustom = new HaspMapCustom();
        haspMapCustom.put("재현", "jaehyeon");
        haspMapCustom.put("빛이 있으라", "fiat_lux");
        haspMapCustom.put("꽃", "flower");
        System.out.println(haspMapCustom.get("재현"));
        System.out.println(haspMapCustom.get("빛이 있으라"));
        System.out.println(haspMapCustom.get("꽃"));
        System.out.println(haspMapCustom.get("w"));
        System.out.println(haspMapCustom.size());
        haspMapCustom.remove("꽃");
    }
}
