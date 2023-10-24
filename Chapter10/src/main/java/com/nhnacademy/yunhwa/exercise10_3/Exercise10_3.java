package com.nhnacademy.yunhwa.exercise10_3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/* 10 - 3
* 자바에 있는 Collections 의 HashMap 사용하지 말고
* 나만의 HashMap 구현 : linked lists using nodes (섹션 9.2.2)
*
* == 주어진 조건 ==
* 키 String, 값 String 인 hash table 만들기
* 제네릭 사용 안하기
* obj.hashCode() 사용해서 만들기
* 테이블의 크기가 너무 꽉 찼으면, 사이즈를 더 늘리지 말기
*
* == 만들 메서드 ==
* get(key)
* put(key, value)
* remove(key)
* containsKey(key)
* size()
*
* */
public class Exercise10_3 {
    static final int CAPACITY = 100;

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(CAPACITY);
        System.out.println(makeHashMap(hashMap));
    }

    @Test
    public void getTest() {
        HashMap hashMap = new HashMap(CAPACITY);
        HashMap finalHashMap = makeHashMap(hashMap);

        Assert.assertTrue(finalHashMap.get("Angela Merkel").equals("010-2345-6789"));

//        Assert.assertTrue(Arrays.stream(hashMap.getBuckets())
//                .map(linkedList -> linkedList.stream()
//                        .map(node -> finalHashMap
//                                .get(node.getKey())
//                                .equals(node.getValue()))
//                        .filter(x -> x))
//                .count() == hashMap.getBuckets().length);
    }

    @Test
    public void removeTest() {
        HashMap hashMap = new HashMap(CAPACITY);
        HashMap finalHashMap = makeHashMap(hashMap);
        finalHashMap.remove("Robert Anderson");

        Assert.assertTrue(Arrays.stream(hashMap.getBuckets())
                .map(linkedList -> linkedList.stream()
                        .map(node -> !node.getKey().equals("Robert Anderson"))
                        .filter(x -> x))
                .count() == hashMap.getBuckets().length);
    }

    @Test
    public void containsKeyTest() {
        HashMap hashMap = new HashMap(CAPACITY);
        HashMap finalHashMap = makeHashMap(hashMap);
        Assert.assertTrue(finalHashMap.containsKey("Kim Ji Un"));
    }

    public static HashMap makeHashMap(HashMap hashMap) {

        hashMap.put("John Doe", "123-456-7890");
        hashMap.put("Jane Smith", "987-654-3210");
        hashMap.put("David Johnson", "555-123-4567");
        hashMap.put("Emily Davis", "111-222-3333");
        hashMap.put("Michael Wilson", "444-555-6666");
        hashMap.put("Sarah Thompson", "010-777-8888");
        hashMap.put("Robert Anderson", "010-9999-0000");
        hashMap.put("Jessica Martinez", "111-222-3333");
        hashMap.put("Daniel Rodriguez", "444-555-6666");
        hashMap.put("Jennifer Lee", "777-888-9999");
        hashMap.put("Kim Ji Un", "010-1234-5678");
        hashMap.put("Angela Merkel", "010-2345-6789");
        hashMap.put("Vladimir Putin", "010-3456-7890");
        hashMap.put("Emmanuel Macron", "010-4567-8901");
        hashMap.put("Justin Trudeau", "010-5678-9012");

        return hashMap;
    }
}
