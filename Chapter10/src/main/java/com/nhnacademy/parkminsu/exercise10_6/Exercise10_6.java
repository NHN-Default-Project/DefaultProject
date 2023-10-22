package com.nhnacademy.parkminsu.exercise10_6;

import com.nhnacademy.parkminsu.exercise10_6.textio.TextIO;

import java.util.*;

public class Exercise10_6 {
    private static int newLineCnt = 1;

    public static void main(String[] args) {
        System.out.println("\n\n   이 프로그램은 입력 파일을 선택하라고 요청합니다.");
        System.out.println("파일에서 발생하는 모든 단어 목록을 작성하며");
        System.out.println("각 단어의 출현 횟수를 기록합니다.");
        System.out.println("이 목록은 알파벳 순서대로 출력되고, 출현 횟수에 따라");
        System.out.println("가장 흔한 단어가 맨 위에, 가장 드문 단어가 맨 끝에 출력됩니다.");
        System.out.println("   입력 파일을 읽은 후, 프로그램은 출력 파일을 선택하라고 요청합니다.");
        System.out.println("파일을 선택하면 단어 목록이 해당 파일에 작성됩니다. 취소하면 목록은");
        System.out.println("표준 출력에 작성됩니다. 모든 단어는 소문자로 변환됩니다.\n\n");
        System.out.print("계속하려면 Enter 키를 누르십시오.");
        TextIO.getln(); // 사용자가 Enter 키를 누를 때까지 대기합니다.
        try {
            if (TextIO.readUserSelectedFile() == false) {
                System.out.println("입력 파일이 선택되지 않았습니다. 종료합니다.");
                System.exit(1);
            }

            // 데이터를 보유할 TreeMap을 생성합니다. 파일을 읽고 파일에서 발견한 단어에 대한 데이터를 기록합니다.
            TreeMap<String, Word> words = new TreeMap<>();
            Map<String, TreeSet<Integer>> map = new TreeMap<>();
            String word = readNextWord();
            while (word != null) {
                word = word.toLowerCase(); // 단어를 소문자로 변환합니다.
                Word data = words.get(word);
                TreeSet<Integer> tree = map.get(word);
                if (word.length() < 3 || word.equals("the")) {
                    word = readNextWord();
                    continue;
                }
                if (data == null) {
                    map.put(word, new TreeSet<>(Collections.singleton(newLineCnt)));
                    words.put(word, new Word(word));
                } else {
                    tree.add(newLineCnt);
                    map.put(word, tree);
                    int cnt = data.getCount();
                    cnt += 1;
                    data.setCount(cnt);
                }
                word = readNextWord();
            }
            System.out.println("파일에서 발견된 서로 다른 단어 수: " + words.size());
            System.out.println();
            if (words.size() == 0) {
                System.out.println("파일에서 단어를 찾지 못했습니다.");
                System.out.println("데이터를 저장하지 않고 종료합니다.");
                System.exit(0);
            }

            // 단어 데이터를 ArrayList로 복사하고, 단어의 출현 빈도 순서로 정렬합니다.
            // 정렬에 사용할 비교자(Comparator)로 람다 표현식을 사용합니다.
            ArrayList<Word> wordsByFrequency = new ArrayList<>(words.values());
            Collections.sort(wordsByFrequency, (a, b) -> b.getCount() - a.getCount());

            // TreeMap 및 목록에서 데이터를 출력합니다.
            TextIO.writeUserSelectedFile(); // 사용자가 취소하면 출력은 자동으로 표준 출력으로 전환됩니다.
            TextIO.putln(words.size() + " 파일에서 발견된 단어:\n");
            TextIO.putln("알파벳 순서로 정렬된 단어 목록 (괄호 안에 출현 횟수):\n");
            for (Word data : words.values())
                TextIO.putln("   " + data.getWord() + " (" + data.getCount() + ")" + " (" + map.get(data.getWord()) + ")");
            TextIO.putln("\n\n출현 빈도 순서로 정렬된 단어 목록:\n");
            for (Word data : wordsByFrequency)
                TextIO.putln("   " + data.getWord() + " (" + data.getCount() + ")" + " (" + map.get(data.getWord()) + ")");

            System.out.println("\n\n완료되었습니다.\n\n");

        } catch (Exception e) {
            System.out.println("죄송합니다. 오류가 발생했습니다.");
            System.out.println("오류 메시지: " + e.getMessage());
            e.printStackTrace();
        }
        System.exit(0); // 파일 대화 상자 사용으로 인해 필요할 수 있습니다.
    }


    /**
     * TextIO에서 다음 단어를 읽어옵니다. 단어를 찾을 때까지 먼저 입력에서 문자가 아닌 것을 건너뜁니다.
     * 단어를 찾기 전에 파일 끝(End-Of-File)에 도달하면 null을 반환합니다. 그렇지 않으면 단어를 읽어 반환합니다.
     * 단어는 문자 시퀀스로 정의됩니다. 또한, 단어에는 앞뒤로 문자로 둘러싸인 경우 아포스트로피가 포함될 수 있습니다.
     *
     * @return TextIO에서 다음 단어 또는 파일 끝에 도달하면 null을 반환합니다.
     */

    private static String readNextWord() {
        char ch = TextIO.peek(); // 입력에서 다음 문자를 살펴봅니다.
        if (ch == '\n' || ch == '.' || ch == ',') {
            newLineCnt++;
        }
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            TextIO.getAnyChar(); // 문자를 읽습니다.
            ch = TextIO.peek(); // 다음 문자를 살펴봅니다.
        }
        if (ch == TextIO.EOF) // 파일 끝에 도달함
            return null;
        // 이 시점에서 다음 문자가 문자임을 알고 있으므로 단어를 읽어옵니다.
        String word = ""; // 읽어온 단어입니다.
        while (true) {
            word += TextIO.getAnyChar(); // 문자를 단어에 추가합니다.
            ch = TextIO.peek(); // 다음 문자를 살펴봅니다.
            if (ch == '\'') {
                // 다음 문자는 아포스트로피입니다. 이를 읽고, 아포스트로피 뒤에 문자가 있는 경우,
                // 아포스트로피와 문자를 모두 단어에 추가하고 단어 읽기를 계속합니다.
                // 아포스트로피 뒤의 문자가 문자가 아닌 경우, 단어가 끝납니다.
                TextIO.getAnyChar(); // 아포스트로피를 읽습니다.
                ch = TextIO.peek(); // 아포스트로피 다음 문자를 살펴봅니다.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek(); // 다음 문자를 살펴봅니다.
                } else
                    break;
            }
            if (word == "\n") {
                return word;
            }

            if (!Character.isLetter(ch)) {
                // 다음 문자가 문자가 아닌 경우, 단어가 끝납니다.
                break;
            }
            // 루프를 빠져나오지 않은 경우, 다음 문자는 문자입니다.
        }
        return word; // 읽어온 단어를 반환합니다.
    }
}
