package com.nhnacademy.main.exercise2;

/**
 * 1. txt 파일을 읽기
 * 2. 읽은 문자열을 소문자로 변환하기
 * 3. 변환한 문자열을 BinaryTree에 저장하기
 * 4. 저장한 Tree의 값들을 꺼내어 txt 파일로 저장하기
 */
public class Exercise9_2 {
    public static void main(String[] args) {
        ReadAndWriteFileByTree textFile = new ReadAndWriteFileByTree();
        textFile.print();
        textFile.writeToFile();
    }
}
