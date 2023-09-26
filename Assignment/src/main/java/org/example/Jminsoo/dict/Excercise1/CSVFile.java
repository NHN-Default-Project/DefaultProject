package org.example.Jminsoo.dict.Excercise1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVFile {
    private final File file;
    private final Map<String, ArrayList<String>> word;


    private CSVFile(Builder builder) {
        this.file = builder.file;
        this.word = builder.word;
    }


    public File getFile() {
        return file;
    }

    public Map<String, ArrayList<String>> getWord() {
        return word;
    }


    public static class Builder {
        private File file;
        private Map<String, ArrayList<String>> word;

        public Builder() {
            this.file = null;
            this.word = new HashMap<>();
        }

        public Builder file(File file) {
            this.file = file;
            return this;
        }

        public Builder word(Map<String, ArrayList<String>> word) {
            this.word = word;
            return this;
        }


        public CSVFile build() {
            return new CSVFile(this);
        }

    }


}