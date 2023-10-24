package com.nhnacademy.gaeun.exercise6;

import java.util.*;

public class Concordance {

    private Map<String, List<Integer>> concordance;

    public Concordance() {
        this.concordance = new HashMap<>();
    }

    private void setConcordance(Map<String, List<Integer>> concordance) {
        this.concordance = concordance;
    }

    public Map<String, List<Integer>> getConcordance() {
        return concordance;
    }

    public void initialSetting(Map<String, List<Integer>> concordance) {
        setConcordance(concordance);
    }
}
