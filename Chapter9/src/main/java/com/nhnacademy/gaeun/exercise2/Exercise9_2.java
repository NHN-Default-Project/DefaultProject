package com.nhnacademy.gaeun.exercise2;

import java.util.List;
import java.util.Scanner;

public class Exercise9_2 {
    public static void main(String[] args) {
        String path = "/Users/kaeun/DefaultProject/Chapter9/src/main/java/com/nhnacademy/gaeun/exercise2/readFIle.txt";
        String writePath = "/Users/kaeun/DefaultProject/Chapter9/src/main/java/com/nhnacademy/gaeun/exercise2/writeFile.txt";
        FileRead fileRead = new FileRead(path);
        WordTree wordTree = fileRead.load();
        FileWrite fileWrite = new FileWrite(writePath);
        fileWrite.writeToFile(wordTree);

//        List<String> wordList = fileRead.load();
//        for (String word : wordList) {
//            System.out.println(word);
//        }

//        while (true) {
//            System.out.println("\n\nEnter a string to be inserted, or press return to end.");
//            System.out.print("?  ");
//            String item;
//            item = in.nextLine().trim().toLowerCase();
//            if (item.length() == 0)
//                break;
//            if (treeContains(root,item)) {
//                System.out.println("\nThat item is already in the tree.");
//            }
//            else {
//                treeInsert(item);
//                System.out.println("\nThe tree contains " + countNodes(root) + " items.");
//                System.out.println("\nContents of tree:\n");
//                treeList(root);
//            }
//        }  // end while
//
//        System.out.println("\n\nExiting program.");
//
//    }  // end main()
    }
}
