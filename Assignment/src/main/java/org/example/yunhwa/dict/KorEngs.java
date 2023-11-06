package org.example.yunhwa.dict;

import java.util.List;

public class KorEngs {
    private String korWord;
    private List<String> engWords;

    public KorEngs(String korWord, List<String> engWords) {
        this.korWord = korWord;
        this.engWords = engWords;
    }

    public String getKorWord() {
        return this.korWord;
    }

    public List<String> getEngWords() {
        return this.engWords;
    }

    public int getEngWordCount() {
        return engWords.size();
    }
}
