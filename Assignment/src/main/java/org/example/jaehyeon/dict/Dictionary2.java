package org.example.jaehyeon.dict;

import java.util.List;

/**
 * 사전.
 * <pre>
 * ===========================================================
 * DATE             AUTHOR               NOTE
 * -----------------------------------------------------------
 * 2023/09/21       김현준                 최초 생성
 * </pre>
 *
 * @author 김현준
 * @since 2023/09/21
 */
public interface Dictionary2 {

    // TODO #1 알맞게 변경 필요

    /**
     * 파일을 읽어 메모리에 적재한다.
     *
     * @param path 파일 경로
     * @author 김현준
     */
    void load(Parser parser, String path);

    /**
     * 한글을 입력받아 영어단어들을 돌려준다.
     *
     * @param kor 한글 단어
     * @return 영단어 리스트
     * @author 김현준
     */
    List<String> findEngByKor(String kor);

    /**
     * 한글 단어가 몇개나 있는지 확인한다.
     * <br>
     * 동음이의어, 동의어는 1개로 간주한다. (중복 X)
     *
     * @return 한글 단어 수
     * @author 김현준
     */
    int count();

    /**
     * 영단어 리스트를 정렬해서 가져온다.
     * <br>
     * 동음이의어 DESC, Kor DESC
     *
     * @return 정렬된 영단어 리스트
     * @author 김현준
     */
    List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc();

}
