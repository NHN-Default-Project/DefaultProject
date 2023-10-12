package com.nhnacademy.parkminsu.exercise9_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int listSize = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("생성할 노드의 갯수를 입력해주세요");
            listSize = Integer.parseInt(inputData(bufferedReader));
            inputDataToList(bufferedReader, binarySortTree, listSize);
            inputDataToQueue(binarySortTree);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputData(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }

    public static void inputDataToList(BufferedReader br, BinarySortTree list, int size) throws IOException {
        if (list.size() == size) {
            return;
        }
        list.add(inputData(br));
        inputDataToList(br, list, size);
    }

    public static void inputDataToQueue(BinarySortTree binarySortTree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(binarySortTree.getRoot());
        for (int i = 0; i < binarySortTree.size(); i++) {
            Node node = queue.poll();
            if (node != null) {
                System.out.println(node.getData());
            }
            assert node != null;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void recursionInputDataToQueue(BinarySortTree binarySortTree) {
        
    }
}
