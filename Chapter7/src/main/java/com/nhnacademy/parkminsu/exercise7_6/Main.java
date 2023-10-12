package com.nhnacademy.parkminsu.exercise7_6;

import com.nhnacademy.parkminsu.textio.TextIO;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ReadFile readFile = new ReadFile("Chapter7/src/main/java/com/nhnacademy/parkminsu/test.txt");
        readFile.load();
        ConversionSortList conversionSortList = new ConversionSortList();
        List<String> list = conversionSortList.conversion(readFile.getReadDataList());
        list = conversionSortList.sort(list);
        TextIO.writeFile("Chapter7/src/main/java/com/nhnacademy/parkminsu/input.txt");
        for (int i = 0; i < list.size(); i++) {
            TextIO.putln(list.get(i));
        }

    }


}
