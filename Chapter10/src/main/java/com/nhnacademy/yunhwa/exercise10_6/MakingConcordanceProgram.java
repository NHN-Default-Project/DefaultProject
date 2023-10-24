package com.nhnacademy.yunhwa.exercise10_6;

import com.nhnacademy.yunhwa.exercise10_6.exceptions.FileNotSelectedException;
import com.nhnacademy.yunhwa.exercise10_6.exceptions.NodataException;
import com.nhnacademy.yunhwa.exercise10_6.text_io.TextIO;

import java.util.Map;
import java.util.TreeSet;

public class MakingConcordanceProgram {
    public static void run() {

        while (true) {
            try {
                printInformationOfProgram();
                String enter = TextIO.getln(); // 유저의 엔터를 기다리기
                if (enter.equals("0")) { // 0이라면 종료
                    break;
                }

                if (!TextIO.readUserSelectedFile()) {
                    throw new FileNotSelectedException("input file 이 선택되지 않았습니다. 다시 입력해주세요");
                }

                Concordance concordance = new Concordance();
                makeIndexOfFile(concordance, 1);
                System.out.printf("파일에서 찾은 다른 단어들의 수 : %d%n", concordance.getIndex().size());

                if (concordance.getIndex().isEmpty()) {
                    throw new NodataException("파일에 단어들이 존재하지 않습니다. 유의미한 파일을 다시 입력해주세요.");
                }

                if (!TextIO.writeUserSelectedFile()) {
                    throw new FileNotSelectedException("output file 이 선택되지 않았습니다. 다시 입력해주세요");
                }

                writeIndexToOutputFile(concordance);
                System.out.println("\n\n========================= 끝 ============================\n\n");
                break;

            } catch (Exception e) {
                System.out.println("죄송합니다. 에러가 발생했습니다.");
                System.out.println("에러 메세지 : " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void printInformationOfProgram() {
        System.out.println("\n\n===================================================");
        System.out.println("이 프로그램은 당신에게 하나의 input file 을 고르도록 요청합니다.");
        System.out.println("그러면 고른 파일에 있는 모든 단어들의 색인 리스트를 만들어 줄 것입니다.");
        System.out.println("색인 리스트에는 단어와 해당 단어가 존재하는 줄의 번호들이 담겨있습니다.");
        System.out.println("출력되는 파일에는 색인 리스트가 담겨있을 것입니다.\n");

        System.out.println("당신의 input file 을 다 읽은 후에는");
        System.out.println("당신은 하나의 output file 을 선택할 수 있습니다.");
        System.out.println("만약 당신이 output file 을 선택한다면 해당 파일에 색인 리스트가 담길 것이고,");
        System.out.println("선택하지 않는다면 표준 출력으로 출력될 것입니다.");
        System.out.println("모든 단어는 소문자로 변환됩니다. 따라서 대소문자가 다르더라도, 동일한 문자로 취급됩니다.");
        System.out.println("===================================================================");
        System.out.println("시작하려면 엔터를 눌러주세요. 종료하려면 0을 입력해주세요.");
    }

    public static void makeIndexOfFile(Concordance concordance, int lineCount) {
        String term = readNextWord();

        while (term != null) { // 파일의 끝이 아닐 때까지
            if (term.equals("\n")) { // 각 줄의 끝이라면
                lineCount++; // 줄 개수 추가
            } else { // 줄의 끝이 아니라면
                term = term.toLowerCase();
                if (! (term.equals("the") || term.length() < 3)) { // the 이거나 3 미만의 단어가 아니면 추가
                    concordance.addReference(term, lineCount);
                }
            }
            term = readNextWord();
        }
    }

    public static void writeIndexToOutputFile(Concordance concordance) {
        TextIO.putln(concordance.getIndex().size() + " 개의 단어들이 파일에서 찾아졌습니다.\n");
        TextIO.putln("===================== 단어들 색인 리스트 ========================");
        for (Map.Entry<String, TreeSet<Integer>> entry : concordance.getIndex().entrySet()) {
            TextIO.putln(String.format("  %-20s", entry.getKey()) +  entry.getValue());
        }
        TextIO.putln("============================================================");
    }

    public static String readNextWord() {
        char ch = TextIO.peek();

        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            if (ch == '\n') { // 각 줄의 끝에 도달 했다면
                TextIO.getAnyChar();
                return "\n"; // "\n" 리턴
            }
            TextIO.getAnyChar();
            ch = TextIO.peek();
        }
        if (ch == TextIO.EOF)
            return null;
        String word = "";
        while (true) {
            word += TextIO.getAnyChar();
            ch = TextIO.peek();
            if (ch == '\'') {
                TextIO.getAnyChar();
                ch = TextIO.peek();
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();
                } else
                    break;
            }
            if (!Character.isLetter(ch)) {
                break;
            }
        }
        return word;
    }
}
