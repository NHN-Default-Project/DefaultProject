package com.nhnacademy.jminsoo.excercise5;

import com.nhnacademy.jminsoo.textio.TextIO;
import java.util.ArrayList;
import java.util.List;



public class Excerciese3_5 {
    public static void main(String[] args) {
        TextIO.readFile("Chapter3/src/main/java/com/nhnacademy/jminsoo/excercise5/sales.dat");
        List<CitySales> citySales = new ArrayList<>();

        double salesSum = 0;
        int notReceiveCount = 0;

        while (!TextIO.eof()) {
            try {
                String str = TextIO.getln();
                citySales.add(new CitySales(str));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        for (CitySales city : citySales) {
            System.out.printf("%s의 매출 : %.2f\n", city.getName(), city.getSales());
            if (!city.isReceived()) {
                notReceiveCount++;
            }
            salesSum += city.getSales();
        }
        System.out.println("총 매출 : " + salesSum);
        System.out.println("데이터가 제공되지 않은 도시의 개수 : " + notReceiveCount);
    }

}
