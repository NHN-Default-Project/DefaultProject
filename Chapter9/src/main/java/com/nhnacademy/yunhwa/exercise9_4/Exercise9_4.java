package com.nhnacademy.yunhwa.exercise9_4;

import com.nhnacademy.yunhwa.exercise9_2.BinarySortTree;
import com.nhnacademy.yunhwa.exercise9_2.ReadFile;
import com.nhnacademy.yunhwa.exercise9_2.WriteFile;


public class Exercise9_4 { // output 없애고 print 만 되게 변경함.
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        ReadFile.readUserSelectedFile();
        binarySortTree.storedStringsInBinarySortTree();
        binarySortTree.printBinartSortTreeUsingQueue();
    }
}
