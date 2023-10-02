package com.nhnacademy.gaeun.exercise6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileRead {
    private final File readFile;
    private final File writeFile;
    private List<String> wordList = new ArrayList<>();
    private StringBuilder oneLine = new StringBuilder();


    public FileRead(String readPath, String writePath) {
        this.readFile = new File(readPath);
        this.writeFile = new File(writePath);
    }

    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(readFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));) {
            int content;
            while ((content = br.read()) != -1) {
                wordToList((char) content);
            }
            System.out.println(wordList);
            while (!wordList.isEmpty()) {
                bw.write(wordList.get(0));
                bw.newLine();
                wordList.remove(0);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void wordToList(char oneWord) {
        if ((Character.isLetter(oneWord) && (oneWord != ' ')) || (oneWord == '\'')) {
            oneLine.append(oneWord);
        } else {
            if (oneLine.length() > 0) {
                wordList.add(oneLine.toString().toLowerCase());
                oneLine.setLength(0);
                System.out.println(wordList);
            }
        }
        sort();

    }

    public void sort() {
        wordList = wordList.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}

