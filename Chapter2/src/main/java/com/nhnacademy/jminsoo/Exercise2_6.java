package com.nhnacademy.jminsoo;

<<<<<<< HEAD
import com.nhnacademy.jminsoo.textio.TextIO;
=======
import textio.TextIO;
>>>>>>> 2930d4a (main rebasing)

public class Exercise2_6 {
    public static void main(String[] args) {
        System.out.println("Please enter your first name and last name, separated by a space");
        String input = TextIO.getlnString();
        String[] names = input.split(" ");

        System.out.printf("Your first name is %s, which has %d characters\n", names[0], names[0].length());
        System.out.printf("Your last name is %s, which has %d characters\n", names[1], names[1].length());
        System.out.printf("Your initials are %s\n",
                String.valueOf(names[0].charAt(0)) + String.valueOf(names[1].charAt(0)));

    }

}
