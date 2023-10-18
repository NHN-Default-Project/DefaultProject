package com.nhnacademy.gaeun.exercise2;

import java.util.TreeSet;

public class Jibhab {
    private final TreeSet<Integer> jibhab;

    public Jibhab(TreeSet<Integer> set) {
        this.jibhab = set;
    }

    public Jibhab addAll(Jibhab B) {
        TreeSet<Integer> A = this.jibhab;
        A.addAll(B.jibhab);
        return new Jibhab(A);
    }

    public Jibhab retainAll(Jibhab B) {
        TreeSet<Integer> A = this.jibhab;
        A.retainAll(B.jibhab);
        return new Jibhab(A);
    }

    public Jibhab removeAll(Jibhab B) {
        TreeSet<Integer> A = this.jibhab;
        A.removeAll(B.jibhab);
        return new Jibhab(A);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int element : jibhab) {
            sb.append(element);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2) + "]";
    }
}
