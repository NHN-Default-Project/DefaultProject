package com.nhnacademy.yunhwa.Exercise3_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Exercise3_5 {
    // "sales.dat" 파일 안의 정보 : 여러 도시에 있는 회사의 매출 수치
    // 각 줄에 도시 이름, 콜론(:), (해당 도시에 대한 매출 수치) 데이터(double) or 데이터가 제공되지 않는 이유를 설명하는 주석

    // ex) "sales.dat" 파일 내용
    // San Francisco:  19887.32
    // Chicago:  no report received
    // New York: 298734.12

    // 모든 도시의 (총 매출)을 함께 계산하고 인쇄하며, (데이터를 사용할 수 없는 도시의 수)도 함께 출력하는 프로그램
    // 각 줄에 대해 콜론까지의 문자를 읽고 무시
    // 나머지 줄을 문자열 유형의 변수로 읽어오기
    // 문자열을 숫자로 변환하고 try, catch 문 사용하여 변환 성공 여부 테스트

    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(Files.newInputStream(Path.of("/Users/yoonhwachoi/Desktop/javaCourse2/ChoiYunhwa/chapter3/Exercise5/sales.dat")));) {
            double salesValue = 0;
            double totalSales = 0;
            int notExistDataCount = 0;
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                int colonIndex = line.indexOf(":");
                String salesValueStr = line.substring(colonIndex + 1).trim();

                if (salesValueStr.charAt(0) >= '0' && salesValueStr.charAt(0) <= '9') {
                    salesValue = Double.valueOf(salesValueStr);
                    totalSales += salesValue;
                } else {
                    notExistDataCount++;
                }
            }
            
            System.out.println("모든 도시의 총 매출 : " + totalSales);
            System.out.println("데이터를 사용할 수 없는 도시의 수 : " + notExistDataCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       
        
    }
}
