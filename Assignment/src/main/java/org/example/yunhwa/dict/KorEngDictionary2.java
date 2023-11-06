package org.example.yunhwa.dict;

import java.util.*;


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
public class KorEngDictionary2 implements KorEngDictionary {

    Map<String, List<String>> readDatas;
    List<KorEngs> korEngsList;

    public KorEngDictionary2() {
        this.readDatas = new HashMap<>();
        this.korEngsList = new ArrayList<>();
    }

    public Map<String, List<String>> getReadDatas() {
        return this.readDatas;
    }

    /**
     * 파일을 읽어 메모리에 적재한다.
     *
     * @param path 파일 경로
     * @author 김현준
     */
    public void load(Parser parser, String path) {
        this.readDatas = parser.parse(path);

        // 생성한 클래스 객체 리스트로 저장 작업 해주기
        for (String korWord : readDatas.keySet()) {
            this.korEngsList.add(new KorEngs(korWord, readDatas.get(korWord)));
        }
    }

    /**
     * 한글을 입력받아 영어단어들을 돌려준다.
     *
     * @param kor 한글 단어
     * @return 영단어 리스트
     * @author 김현준
     */
    public List<String> findEngByKor(String kor) {
        // kor 이 key 값, key 를 입력받아, value 를 리턴
        return this.readDatas.get(kor);
    }

    /**
     * 한글 단어가 몇개나 있는지 확인한다.
     * <br>
     * 동음이의어, 동의어는 1개로 간주한다. (중복 X)
     *
     * @return 한글 단어 수
     * @author 김현준
     */
    public int count() {
        return this.readDatas.size();
    }

    /**
     * 모든 한글 단어 목록을 가져온다.
     *
     * @return 한글 단어 콜렉션 // TODO 적절한 자료구조로 리턴 타입 변경
     * @author 김현준
     */
    @Override
    public Set<String> findAllListKor() {
        return this.readDatas.keySet();
    }

    /**
     * 영단어 리스트를 정렬해서 가져온다.
     * <br>
     * 동음이의어 DESC, Kor DESC
     *
     * @return 정렬된 영단어 리스트
     * @author 김현준
     */
    List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
        List<String> sortedEngsList = new ArrayList<>();

        // key, value 모두를 가져오기 이해 entrySet() 을 리스트로 변환
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(this.readDatas.entrySet());

        entries.sort((o1, o2) -> {
            int count = o2.getValue().size() - o1.getValue().size();

            if (count == 0) {
                return o2.getKey().compareTo(o1.getKey());
            }

            return count;
        });

        for (Map.Entry<String, List<String>> entry : entries) {
            for (String engWord : entry.getValue()) {
                sortedEngsList.add(engWord);
            }
        }

        return sortedEngsList;
    }

    List<String> findAllEngByKorOrderByHomonymCountDescAndKorDescByClass() {
        List<String> sortedEngsList = new ArrayList<>();

        korEngsList.stream()
                .sorted(Comparator.comparing(KorEngs::getEngWordCount, Comparator.reverseOrder())
                        .thenComparing(KorEngs::getKorWord, Comparator.reverseOrder()))
                .map(KorEngs::getEngWords)
                .forEach(engWords -> {
                    for (String engWord: engWords) {
                        sortedEngsList.add(engWord);
                    }
                });

        return sortedEngsList;
    }


    List<String> findAllEngByKorOrderByHomonymCountAscAndKorAsc() {
        List<String> sortedEngsList = new ArrayList<>();

        korEngsList.stream()
                .sorted(Comparator.comparing(KorEngs::getEngWordCount)
                        .thenComparing(KorEngs::getKorWord))
                .map(KorEngs::getEngWords)
                .forEach(engWords -> {
                    for (String engWord: engWords) {
                        sortedEngsList.add(engWord);
                    }
                });

        return sortedEngsList;
    }

}



