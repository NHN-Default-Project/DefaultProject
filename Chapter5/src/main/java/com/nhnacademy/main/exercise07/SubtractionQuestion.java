package com.nhnacademy.main.exercise07;

public class SubtractionQuestion implements IntQuestion {
    private int a;
    private int b;

    public SubtractionQuestion() { // constructor
        do {
            this.a = (int) (Math.random() * 50 + 1);
            this.b = (int) (Math.random() * 50);
        }
        while (this.a - this.b < 0);

    }

    @Override
    public String getQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append("What is ")
                .append(this.a)
                .append(" - ")
                .append(this.b)
                .append(" ?");
        return sb.toString();
    }

    @Override
    public int getCorrectAnswer() {
        return this.a - this.b;
    }
}
