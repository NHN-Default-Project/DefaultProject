package com.nhnacademy.parkminsu.exercise7_6;

import com.nhnacademy.parkminsu.textio.TextIO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TextIO.readFile("Chapter7/src/main/java/com/nhnacademy/parkminsu/test.txt");
        List<String> list = new ArrayList<>();
        while (TextIO.eof()) {
            
        }
    }

    private static String readNextWord() {
        char ch = TextIO.peek(); // 입력의 다음 문자를 확인합니다.
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            // 문자가 아닌 문자를 건너뜁니다.
            TextIO.getAnyChar();  // 문자를 읽습니다.
            ch = TextIO.peek();   // 다음 문자를 확인합니다.
        }
        if (ch == TextIO.EOF) // 파일의 끝을 만났습니다.
            return null;
        // 이 시점에서 다음 문자가 문자임을 알고 있으므로 단어를 읽습니다.
        String word = "";  // 읽을 단어입니다.
        while (true) {
            word += TextIO.getAnyChar();  // 문자를 단어에 추가합니다.
            ch = TextIO.peek();  // 다음 문자를 확인합니다.
            if (ch == '\'') {
                // 다음 문자가 아포스트로피입니다. 읽고, 아포스트로피 뒤에 문자가 있는 경우
                // 아포스트로피와 문자를 단어에 추가하고 계속 단어를 읽습니다.
                // 아포스트로피 뒤에 문자가 아닌 경우 단어가 완료되므로 루프를 빠져나옵니다.
                TextIO.getAnyChar();   // 아포스트로피를 읽습니다.
                ch = TextIO.peek();    // 아포스트로피 뒤의 문자를 확인합니다.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // 다음 문자를 확인합니다.
                } else
                    break;
            }
            if (!Character.isLetter(ch)) {
                // 다음 문자가 문자가 아닌 경우 단어가 완료되므로 루프를 빠져나옵니다.
                break;
            }
            // 루프에서 빠져나오지 않았다면 다음 문자는 문자입니다.
        }
        return word;  // 읽은 단어를 반환합니다.
    }
}
