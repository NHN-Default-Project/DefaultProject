package com.nhnacademy.yunhwa.exercise10_6;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Concordance {
    private TreeMap<String, TreeSet<Integer>> index;

    public Concordance() {
        this.index = new TreeMap<>(String::compareToIgnoreCase);
    }

    public TreeMap<String, TreeSet<Integer>> getIndex() {
        return this.index;
    }

    public void addReference(String term, int lineNum) {
        TreeSet<Integer> references = index.get(term);

        if (references == null) {
            TreeSet<Integer> firstRef = new TreeSet<>();
            firstRef.add(lineNum);
            index.put(term, firstRef);
        } else {
            references.add(lineNum);
        }
    }

    public void printIndex() {
        for (Map.Entry<String, TreeSet<Integer>> entry : index.entrySet()) {
            String term = entry.getKey();
            TreeSet<Integer> lineNumSet = entry.getValue();

            System.out.print(term + " : ");
            int firstLine = lineNumSet.first();
            System.out.print(firstLine);

            for (int lineNum : lineNumSet.tailSet(firstLine + 1)) {
                System.out.print(", " + lineNum);
            }
            System.out.println();
        }
    }

}
