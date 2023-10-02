package com.nhnacademy.gaeun.exercise3;

import java.util.Scanner;

/*
* https://math.hws.edu/javanotes/c8/exercises.html
* Constructor 2: One constructs a Roman numeral from a string,
* The other constructor constructs a Roman numeral from an int.
* Instance Method 2: convert an int into the string that represents the corresponding Roman numeral
 */
public class Exercise8_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try{
                System.out.println("Please enter Roman numerals or Arabic numerals");
                System.out.println("If you wish to exit, please press enter");
                String inputValue = scanner.nextLine();
                if(inputValue.equals("")) {
                    break;
                }
                if(isRoman(inputValue)) {
                    RomanNumerals romanNumerals = new RomanNumerals(inputValue);
                    System.out.println(romanNumerals.getArabicNumeral());
                } else {
                    RomanNumerals romanNumerals1 = new RomanNumerals(Integer.parseInt(inputValue));
                    System.out.println(romanNumerals1.getRomanNumeral());
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isRoman(String inputValue) {
        return Character.isLetter(inputValue.charAt(0));
    }

}
