package com.nhnacademy.Jminsoo.exercise6;

import com.nhnacademy.Jminsoo.exercise6.textio.TextIO;

import java.util.*;

/**
 * 이 프로그램은 입력 파일에서 단어를 읽고 각 단어의 발생 횟수를 세는 프로그램입니다.
 * 단어 데이터는 출력 파일에 두 번 기록됩니다. 먼저 알파벳 순서대로, 그 다음으로는 발생 횟수 순으로 기록됩니다.
 * 사용자는 입력 파일과 출력 파일을 지정합니다.
 * <p>
 * 이 프로그램은 제네릭 프로그래밍을 위한 Java 프레임워크의 여러 부분을 보여줍니다: TreeMap, List 정렬, Comparators 등.
 */
public class WordIndex {
//    private TreeMap<String, WordData> words;

    private int wordLine;

    public WordIndex() {
        this.wordLine = 1;
    }

    /**
     * 단어에 관한 데이터를 나타냅니다: 단어와 단어가 몇 번 발견되었는지를 나타내는 횟수입니다.
     */
    private static class WordData {
        String word;
        int count;
        Set<Integer> lineSet;

        WordData(String w, int lineNumber) {
            // 새로운 단어를 만났을 때 WordData 객체를 생성하는 생성자입니다.
            this.word = w;
            this.count = 1;  // 횟수의 초기값은 1입니다.
            this.lineSet = new HashSet<>();
            this.lineSet.add(lineNumber);
        }
    } // end class WordData

    public void test() {
        System.out.println("\n\n   이 프로그램은 입력 파일을 선택하도록 요청합니다.");
        System.out.println("파일에 나타나는 모든 단어 목록과 각 단어의 발생 횟수를 생성합니다.");
        System.out.println("이 목록은 먼저 알파벳 순으로, 그 다음에는 발생 빈도 순으로 출력됩니다.");
        System.out.println("가장 흔한 단어가 맨 위에 있고 가장 드문 단어가 맨 아래에 있습니다.");
        System.out.println("   입력 파일을 읽은 후, 출력 파일을 선택하도록 요청합니다.");
        System.out.println("파일을 선택하면 단어 목록이 그 파일에 기록됩니다. 취소하면 목록이 표준 출력에 기록됩니다.");
        System.out.println("모든 단어는 소문자로 변환됩니다.\n\n");
        System.out.print("계속하려면 Enter를 누르세요.");
        TextIO.getln();  // 사용자가 Enter를 누를 때까지 대기합니다.

        try {
            if (TextIO.readUserSelectedFile() == false) {
                System.out.println("선택된 입력 파일이 없습니다. 종료합니다.");
                System.exit(1);
            }

            // 데이터를 보관하기 위한 TreeMap을 생성하고 파일을 읽어 단어에 관한 데이터를 기록합니다.
            TreeMap<String, WordData> words = new TreeMap<>();
            String word = readNextWord();

            while (word != null) {
                word = word.toLowerCase();  // 단어를 소문자로 변환합니다.
                WordData data = words.get(word);
                if (data == null) {
                    words.put(word, new WordData(word, this.wordLine));
                } else {
                    data.count++;
                    data.lineSet.add(this.wordLine);
                }
                word = readNextWord();
            }

            words.remove("");

            System.out.println("파일에서 찾은 다른 단어 수:  " + words.size());
            System.out.println();
            if (words.size() == 0) {
                System.out.println("파일에서 단어를 찾지 못했습니다.");
                System.out.println("데이터를 저장하지 않고 종료합니다.");
                System.exit(0);
            }

            // 단어 데이터를 ArrayList에 복사하고 빈도 순서대로 정렬합니다. 정렬에 사용될 Comparator를 사용하기 위해 람다 표현식을 사용합니다.
            ArrayList<WordData> wordsByFrequency = new ArrayList<>(words.values());
            Collections.sort(wordsByFrequency, (a, b) -> b.count - a.count);

            // Map과 List에서 데이터를 출력합니다.
            TextIO.writeUserSelectedFile(); // 사용자가 취소할 경우 출력은 자동으로 표준 출력으로 이동합니다.
            TextIO.putln(words.size() + " 파일에서 찾은 단어:\n");
            TextIO.putln("알파벳 순서로 정렬된 단어 목록"
                    + " (괄호 안에 발생 횟수가 있음):\n");
            for (WordData data : words.values()) {
                TextIO.put("   " + data.word + " (" + data.count + ")");
                TextIO.putln("  줄번호 : " + data.lineSet);
            }
            TextIO.putln("\n\n발생 빈도순으로 정렬된 단어 목록:\n");
            for (WordData data : wordsByFrequency) {
                TextIO.put("   " + data.word + " (" + data.count + ")");
                TextIO.putln("  줄번호 : " + data.lineSet);
            }
            System.out.println("\n\n완료되었습니다.\n\n");

        } catch (Exception e) {
            System.out.println("죄송합니다, 오류가 발생했습니다.");
            System.out.println("오류 메시지:  " + e.getMessage());
            e.printStackTrace();
        }
        System.exit(0);  // 파일 대화 상자 사용으로 인해 필요할 수 있습니다.
    }

    /**
     * TextIO에서 다음 단어를 읽어옵니다. 먼저 입력에서 문자가 아닌 문자를 건너뛰고 단어를 찾습니다.
     * 단어를 찾기 전에 파일 끝이 나타나면 null을 반환합니다. 그렇지 않으면 단어를 읽어 반환합니다.
     * 단어는 문자 시퀀스로 정의됩니다. 또한 단어에는 각 측면에 문자로 둘러싸인 경우 아포스트로피를 포함할 수 있습니다.
     *
     * @return TextIO에서 다음 단어 또는 파일 끝을 반환하거나 파일 끝을 만나면 null을 반환합니다.
     */
    private String readNextWord() {
        char ch = TextIO.peek(); // 입력의 다음 문자를 확인합니다.
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            if (ch == '\n') {
                this.wordLine++; //현재 읽는 문자의 라인
            }

            TextIO.getAnyChar();  // 문자를 읽습니다.
            ch = TextIO.peek();   // 다음 문자를 확인합니다.
        }
        if (ch == TextIO.EOF) { // 파일 끝을 만났습니다.
            return null;
            // 이 시점에서 다음 문자가 문자임을 알고 있으므로 단어를 읽어옵니다.
        }
        StringBuilder word = new StringBuilder();  // 읽어올 단어입니다.
        while (true) {
            word.append(TextIO.getAnyChar());  // 문자를 단어에 추가합니다.
            ch = TextIO.peek();  // 다음 문자를 확인합니다.

            if (ch == '\'') {
                // 다음 문자는 아포스트로피입니다. 이것을 읽고, 아포스트로피 다음에 문자가 있는 경우 아포스트로피와 문자를 단어에 추가하고 계속 단어를 읽어갑니다.
                // 아포스트로피 뒤의 문자가 문자가 아닌 경우, 단어가 완료됩니다.
                TextIO.getAnyChar();   // 아포스트로피를 읽습니다.
                ch = TextIO.peek();    // 아포스트로피 다음 문자를 확인합니다.
                if (Character.isLetter(ch)) {
                    word.append("\'")
                            .append(TextIO.getAnyChar());
                    ch = TextIO.peek();  // 다음 문자를 확인합니다.
                } else {
                    break;
                }
            }
            if (!Character.isLetter(ch)) {
                // 다음 문자가 문자가 아닌 경우, 단어가 완료되므로 루프를 빠져나옵니다.
                break;
            }
            // 루프에서 나가지 않았다면 다음 문자는 문자입니다.
        }
        if (word.toString().equalsIgnoreCase("the") || word.length() < 3) {
            return "";
        } else {
            return word.toString();  // 읽은 단어를 반환합니다.
        }
    }
} // end class WordCount
