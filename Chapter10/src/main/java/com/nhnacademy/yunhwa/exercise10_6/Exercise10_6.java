package com.nhnacademy.yunhwa.exercise10_6;

/* 10 - 6
 * 하위 섹션 10.4.2 의 책의 색인을 만드는 프로그램 기반으로
 * 문서에 대한 색인을 만드는 프로그램 작성하기
 *
 * ====================  주어진 조건  ========================
 * 문서는 input file 로부터 읽어오고,
 * 문서로부터 얻은 concordance data 는 output file 에 기록되어야 함.
 *
 * 색인은 문서에 나오는 모든 단어를 나열하고,
 * 각 단어에 대해 문서에서 해당 단어가 나오는 모든 줄의 줄 번호를 제공함.
 *
 * 섹션 10.4.2 WordCount.java 과의 차이점 :
 * 색인의 정수가 페이지 번호 -> 줄의 번호
 *
 * 하위 섹션의 인덱싱 서브루틴을 사용할 수 있음, (static 메서드)
 * 대신 System.out 대신 TextIO 에 데이터를 기록하는 것으로 수정해야함.
 *
 * input file 과 output file 은 run 할 때,
 * 사용자로부터 선택되어야 함.
 *
 * 파일을 읽으면서 만나는 각 단어를
 * 현재 줄 번호와 함께 색인에 추가하기
 *
 * input file 에서 파일의 각 줄의 끝은 개행 문자 '\n' 로 표시된다.
 * 이 개행 문자를 만날 때마다 줄 번호를 1 추가해야 한다.
 *
 * WordCount.java 는 줄 끝을 무시한다.
 * 그런데 우리는 줄 끝 문자를 찾아 계산 해야하기 때문에,
 * 우리의 프로그램은 WordCount.java 와 정확히 동일한 방식으로
 * input file 을 처리할 수는 없다.
 *
 * 또한, 우리는 파일의 끝을 탐지해야 한다. 그 방법으로
 * TextIO.peek() 메서드는 입력에서 다음 문자를 미리 보는 데 사용되고,
 * 파일의 끝에서는, TextIO.EOF 를 리턴해준다.
 *
 * concordancd data 에 "the" 는 제외시키자.
 * 길이 3 미만인 단어는 제외시키자.
 * */
public class Exercise10_6 {

    public static void main(String[] args) {
        MakingConcordanceProgram.run();
    }
}
