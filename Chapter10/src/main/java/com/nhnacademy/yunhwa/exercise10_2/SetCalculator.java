package com.nhnacademy.yunhwa.exercise10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static com.nhnacademy.yunhwa.exercise10_2.CheckingStandards.*;

public class SetCalculator {
    private final Queue<TreeSet<Integer>> setQueue;
    private final Queue<Character> operatorQueue;

    public SetCalculator() {
        this.setQueue = new LinkedList<>();
        this.operatorQueue = new LinkedList<>();
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            while (true) {
                ConsoleUserInterface consoleUI = new ConsoleUserInterface();
                consoleUI.beforeInputPrintInformation();

                String line = consoleUI.userInput(br);

                if (!makeSets(line) || !makeOperators(line)) { // try with resources 사용하게 되면서, catch를 메서드 내부에서 잡게 되면서 continue 로 변경
                    continue;
                }

                System.out.println("계산 결과 집합 : " + calculateAllSets());
                if (!consoleUI.isUserWantToBeContinued(br)) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Set<Integer> calculateAllSets() {
        TreeSet<Integer> setA;
        try {
            if (setQueue.peek() != null) {
                setA = setQueue.poll(); // 처음 집합 미리 꺼내기
            } else {
                throw new NoSuchElementException("set queue 에 아무 값이 존재하지 않습니다. 연산을 종료합니다.");
            }

            while (setQueue.peek() != null && operatorQueue.peek() != null) {
                char operator = operatorQueue.poll();
                TreeSet<Integer> setB = setQueue.poll();
                setA = CalculateSet.calculateResult(setA, setB, operator);
            }
            return setA;

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private boolean makeSets(String line) { // 원래 리턴 void 타입 -> try with resources 사용하게 되면서, 버퍼드리더 catch로 넘어가지 않기 위해 boolean 타입으로 변환
        boolean result = false;
        try {
            //  [1,2,3]  [3,5,7] ... 만들어 주기
            List<String> tmpSets = Arrays.stream(line.split("\\+|\\*|-"))
                    .map(string -> string.replace(" ", ""))
                    .collect(Collectors.toList());

            checkValidInput(line);
            checkNegativeIntegerBySetCount(line, tmpSets);

            // []로 감싸진 숫자 문자열들 -> int로 만들어 set에 넣어주기
            for (String tmpSet : tmpSets) {
                TreeSet<Integer> set = new TreeSet<>();

                String strNums = tmpSet
                        .replace("[", "")
                        .replace("]", "");

                if (!strNums.contains(",")) { // 숫자 하나만 존재하는 집합
                    int num = Integer.parseInt(strNums);
                    checkNegativeInteger(num);
                    set.add(num);
                    setQueue.add(set);
                } else { // 숫자 여러 개 존재하는 집합
                    String[] tmpNums = strNums.split(",");
                    for (String strNum : tmpNums) {
                        int num = Integer.parseInt(strNum);
                        checkNegativeInteger(num);
                        set.add(num);
                    }
                    setQueue.add(set);
                }
            }
            result = true;
        } catch (NegativeIntegerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private boolean makeOperators(String line) { // 원래 리턴 void 타입 -> try with resources 사용하게 되면서, 버퍼드리더 catch로 넘어가지 않기 위해 boolean 타입으로 변환
        boolean result = false;
        try {
            line = line.replace(" ", "");

            char[] lineChr = line.toCharArray();

            boolean openBracket = false;
            for (char c : lineChr) {
                if (c == '[') {
                    openBracket = true;
                } else if (c == ']') {
                    openBracket = false;
                } else if (c == '+' || c == '*' || c == '-') {
                    if (!openBracket) {
                        operatorQueue.add(c);
                    }
                } else if (c != ',' && !Character.isDigit(c)) {
                    throw new IllegalArgumentException("입력값에 이상한 값이 들어왔습니다. 형식에 맞춰서 다시 적어주세요");
                }
            }
            result = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}