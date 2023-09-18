package com.nhnacademy.parkminsu.Exercise3_5;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Exercise3_5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of("/Users/minsu/Desktop/JavaFxProgram/sales.dat"))) {
            double total = 0.0;
            String str = "";
            int cityNoDataCnt = 0;
            int cityDataCnt = 0;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                str = str.substring(str.indexOf(":") + 1);
                while (str.indexOf(" ") >= 0) {
                    str = str.substring(str.indexOf(" ") + 1);
                    System.out.println(str);
                }
                try {
                    if (str.equals("no report received")) {
                        continue;
                    } else {
                        total += Double.parseDouble(str);
                        cityDataCnt++;
                    }
                } catch (NumberFormatException e) {

                }
                cityNoDataCnt++;

            }
            System.out.printf("도시별 총 매출 : %f\n데이터가 제공되지 않은 도시 수 : %d", total, cityNoDataCnt - cityDataCnt);

        } catch (IOException e) {
            System.out.println("에러");
        }
    }
}