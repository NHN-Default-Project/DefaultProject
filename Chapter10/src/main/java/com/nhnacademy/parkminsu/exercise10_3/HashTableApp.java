package com.nhnacademy.parkminsu.exercise10_3;

import com.nhnacademy.parkminsu.exercise10_3.exception.DataEntryFormatException;
import com.nhnacademy.parkminsu.exercise10_3.exception.NegativeNumException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class HashTableApp {
    private final String endCommand = "end";

    /**
     * 해당 인터프리터방식의 프로그램을 실행시키는 메서드
     * 입력하는 데이터의 방식 또는 타입이 다르면 Throw를 던짐
     */
    public void progress() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("해시테이블의 size를 입력해주세요");
            String data = checkEnterData(br);
            InputDataFrameRule.isCheckNegativeNum(data); // 음수 체크
            int hashSize = Integer.parseInt(data);
            HashTable hashTable = new HashTable(hashSize); // 사용자가 입력한 사이즈만큼 해쉬 테이블 생성

            System.out.println("해쉬 테이블의 목록: " + hashTable.toString());
            while (true) {
                printInstructions(); // 안내 문구
                String inputInstructions = inputData(br); // 사용자가 입력받음
                if (inputInstructions.toLowerCase().equals(this.endCommand)) {
                    break;
                }

                callMethodAccordingToInputValue(inputInstructions, br, hashTable);
            }

        } catch (IOException | DataEntryFormatException | NegativeNumException | NullPointerException |
                 NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 사용자의 입력을 받는 메서드
     * return 공백을 제거한 String의 값으로 반환
     */
    public String inputData(BufferedReader br) throws IOException {
        String inputStringData = "";
        inputStringData = br.readLine().trim();
        return inputStringData;
    }


    public String checkEnterData(BufferedReader br) throws IOException, NegativeNumException, DataEntryFormatException {
        String data = inputData(br);
        InputDataFrameRule.isCheckStringDataFrame(data);
        return data;
    }

    public void inputDataToHashTable(BufferedReader br, HashTable hashTable) throws IOException, DataEntryFormatException {
        while (true) {
            System.out.println("데이터를 입력하세요(공백으로 구분, end 입력 시 입력 종료)");
            String str = inputData(br);
            InputDataFrameRule.isCheckHashTableDataFrame(str);
            if (str.toLowerCase().equals(this.endCommand)) {
                break;
            } else if (InputDataFrameRule.isCheckHashTableDataFrame(str)) {
                String[] splitStr = str.split(" ");
                hashTable.put(splitStr[0], splitStr[1]);
            } else {
                throw new DataEntryFormatException("데이터 형식이 맞지 않습니다");
            }
        }
    }


    private void execute(String inputData, BufferedReader br, HashTable hashTable) throws IOException, DataEntryFormatException, NegativeNumException {
        while (true) {
            System.out.println("해당 메소드에 들어갈 데이터를 입력하세요(end 입력 시 이전으로 돌아감)");
            String methodData = checkEnterData(br);
            if (methodData.toLowerCase().equals(this.endCommand)) {
                break;
            }
            Object getData = executeConditionMethod(inputData, methodData, hashTable);
            if (getData == null) {
                System.out.println("찾는 값이 없습니다");
            } else {
                printMethodResultValue(getData);
            }
        }
    }

    private void callMethodAccordingToInputValue(String inputData, BufferedReader br, HashTable hashTable) throws DataEntryFormatException, IOException, NegativeNumException {
        CallMethodName callMethodName = CallMethodName.valueOf(callMethodName(inputData));
        switch (callMethodName) {
            case GET:
            case REMOVE:
            case CONTAINKEY:
                execute(inputData, br, hashTable);
                break;
            case PUT:
                inputDataToHashTable(br, hashTable);
                break;
            case TABLELIST:
                printMethodResultValue(hashTable.toString());
                break;
            case SIZE:
                printMethodResultValue(String.valueOf(hashTable.size()));
                break;
            default:
                throw new DataEntryFormatException("입력값을 잘못 입력하셨습니다");
        }
    }

    private Object executeConditionMethod(String inputData, String methodData, HashTable hashTable) throws DataEntryFormatException {
        CallMethodName callMethodName = CallMethodName.valueOf(callMethodName(inputData));
        switch (callMethodName) {
            case GET:
                return executeMethod(hashTable::get, methodData);
            case REMOVE:
                return executeMethod(hashTable::remove, methodData);
            case CONTAINKEY:
                Predicate<String> predicate = hashTable::containKey;
                return predicate.test(methodData);
            default:
                throw new DataEntryFormatException("입력 값을 잘못 입력하셨습니다");
        }
    }

    private <T> T executeMethod(UnaryOperator<T> method, T data) { // get 메소드 호출
        return method.apply(data);
    }

    public String callMethodName(String str) {
        for (CallMethodName num : CallMethodName.values()) {
            if (num.ordinal() == Integer.parseInt(str)) {
                return num.name();
            }
        }
        return null;
    }

    public void printInstructions() {
        System.out.println("\n해당 번호를 입력하세요");
        System.out.println("0. 프로그램 종료 1. 데이터 찾기(get) 2. 데이터 입력(put) 3. 해시 테이블 목록 보기");
        System.out.println("4. 데이터 삭제(remove) 5. 찾는 데이터 유무 확인(containKey) 6. 해시 테이블 크기 보기");
    }

    public void printMethodResultValue(Object value) {
        System.out.println("결과: " + value.toString());
    }

}
