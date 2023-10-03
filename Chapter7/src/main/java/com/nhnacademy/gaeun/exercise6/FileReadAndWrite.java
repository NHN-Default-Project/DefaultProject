package com.nhnacademy.gaeun.exercise6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadAndWrite {
    private final File readFile;
    private final File writeFile;
    private List<String> wordList = new ArrayList<>();


    public FileReadAndWrite(String readPath, String writePath) {
        this.readFile = new File(readPath);
        this.writeFile = new File(writePath);
    }
    public void readAndWrite() {
        loadFile();
        sort();
        writeFile();
    }

    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(readFile))) {
            int content;
            while ((content = br.read()) != -1) {
                convertWordToList((char) content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("존재하지 않는 파일입니다.");
        } catch (IOException e) {
        }
    }
    public void writeFile() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile))) {
            while (!wordList.isEmpty()) {
                bw.write(wordList.get(0));
                bw.newLine();
                wordList.remove(0);
            }
        } catch (IOException e) {
        }
    }

    public void convertWordToList(char oneWord) {
        StringBuilder oneLine = new StringBuilder();
        if ((Character.isLetter(oneWord) && (oneWord != ' ')) || (oneWord == '\'')) {
            oneLine.append(oneWord);
        } else if (oneLine.length() > 0) {
            wordList.add(oneLine.toString().toLowerCase());
            oneLine.setLength(0);
            System.out.println(wordList);
        }
    }

    public void sort() {
        wordList = wordList.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}

