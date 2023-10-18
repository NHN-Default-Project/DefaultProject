package com.nhnacademy.Jminsoo.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public class MyInterpreter {
    private final MyHashTable myHashTable;
    private Commands cmd;
    private Queue<String> dataQueue;

    public MyInterpreter() {
        this.myHashTable = new MyHashTable();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                this.dataQueue = new LinkedList<>();

                System.out.println("명령어를 입력해주세요(공백 입력 시 종료)");
                System.out.println("목록 : put, get, size, remove, isEmpty, containsKey, containsValue, keySet, Values, EntrySet");
                System.out.print(": ");
                String inputStr = br.readLine();
                if (inputStr.isEmpty()) {
                    break;
                }
                this.dataQueue = readLine(inputStr);
                this.cmd = getCommand(dataQueue.poll());
                execute();

            } catch (NullPointerException e) {
                System.out.println("찾는 Key에 해당하는 값이 없습니다!");
            } catch (IOException e) {
                System.out.println("Buffered Reader에 이상이 있습니다!");

            } catch (IllegalArgumentException e) {
                System.out.println("입력값에 문제가 있습니다!");
            }
        }
        br.close();
    }

    public Queue<String> readLine(String inputStr) throws IOException {
        //입력 받기


        List<String> inputStringList = Arrays.asList(inputStr.split(" "));
        //첫 명령어 소문자로 변경(대/소문자 구분안하기 위함)
        inputStringList.set(0, inputStringList.get(0).toLowerCase());
        return new LinkedList<>(inputStringList);
    }

    private void execute() {
        switch (this.cmd) {
            case PUT:
                calculate(queue -> this.myHashTable.put(queue.poll(), queue.poll()), dataQueue);
                break;

            case GET:
                calculate(queue -> this.myHashTable.get(queue.poll()), dataQueue);
                break;

            case REMOVE:
                calculate(queue -> this.myHashTable.remove(queue.poll()), dataQueue);
                break;

            case SIZE:
                calculate(queue -> String.valueOf(this.myHashTable.size()), dataQueue);
                break;

            case IsEMPTY:
                calculate(queue -> String.valueOf(this.myHashTable.isEmpty()), dataQueue);
                break;

            case ContainsKEY:
                calculate(queue -> String.valueOf(this.myHashTable.containsKey(queue.poll())), dataQueue);
                break;

            case ContainsValue:
                calculate(queue -> String.valueOf(this.myHashTable.containsValue(queue.poll())), dataQueue);
                break;

            case KeySET:
                calculate(queue -> String.valueOf(this.myHashTable.keySet()), dataQueue);
                break;

            case VALUES:
                calculate(queue -> String.valueOf(this.myHashTable.values()), dataQueue);
                break;

            case EntrySET:
                calculate(queue -> String.valueOf(this.myHashTable.entrySet()), dataQueue);
                break;
            default:
                throw new IllegalArgumentException("입력 값에 이상이 있습니다!");
        }
    }

    private void calculate(Function<Queue<String>, String> consumer, Queue<String> dataQueue) {
        System.out.println("연산 결과 : " + consumer.apply(dataQueue));
        System.out.println("현재 HashTable의 내용");
        System.out.println(this.myHashTable + "\n");
    }


    private Commands getCommand(String str) {
        for (Commands command : Commands.values()) {
            if (command.value.equals(str)) {
                return command;
            }
        }
        throw new IllegalArgumentException();
    }


    private enum Commands {
        PUT("put"),
        GET("get"),
        REMOVE("remove"),
        COLLECT("collect"),
        SIZE("size"),
        IsEMPTY("isempty"),
        ContainsKEY("containskey"),
        ContainsValue("containsvalue"),
        //        PutALL("putall"),
        KeySET("keyset"),
        VALUES("values"),
        EntrySET("entryset");

        private final String value;

        Commands(String value) {
            this.value = value;
        }
    }

}
