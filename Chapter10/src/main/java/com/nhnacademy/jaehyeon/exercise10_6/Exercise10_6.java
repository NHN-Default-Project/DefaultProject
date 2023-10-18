package com.nhnacademy.jaehyeon.exercise10_6;

public class Exercise10_6 {
    public static void main(String[] args) {
        FileSelector fileSelector = new FileSelector();
        String readFilePath = fileSelector.selectReadFile();

        FileRead fileRead = new FileRead(readFilePath);
        fileRead.readFileOneLine();

        String writeFilePath = fileSelector.selectWriteFile();
        FileWrite fileWrite = new FileWrite(writeFilePath);

        fileWrite.writeFile(fileRead.getWordList());
        System.exit(0);
    }
}
