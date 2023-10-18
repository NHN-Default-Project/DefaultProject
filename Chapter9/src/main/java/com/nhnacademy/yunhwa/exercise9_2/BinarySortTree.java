package com.nhnacademy.yunhwa.exercise9_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이 프로그램은 이진 정렬 트리를 처리하는 몇 가지 루틴을 보여줍니다.
 * 이 프로그램은 문자열의 이진 정렬 트리를 사용합니다. 사용자가 문자열을 입력합니다.
 * 사용자의 문자열은 소문자로 변환되며 --
 * 이미 트리에 없는 경우에만 -- 트리에 삽입됩니다.
 * 그런 다음 트리의 노드 수 및 트리의 항목 목록이 출력됩니다.
 * 사용자가 빈 문자열을 입력하면 프로그램이 종료됩니다.
 */
public class BinarySortTree {

    /**
     * TreeNode 유형의 객체는 문자열 이진 트리의 한 노드를 나타냅니다.
     */
    private static class TreeNode {
        String item;      // 이 노드의 데이터.
        TreeNode left;    // 왼쪽 서브 트리로의 포인터.
        TreeNode right;   // 오른쪽 서브 트리로의 포인터.

        TreeNode(String str) {
            // 생성자. 지정된 문자열을 포함하는 노드를 만듭니다.
            // 참고: left 및 right 포인터는 초기에 null입니다.
            item = str;
        }
    }  // 중첩 클래스 TreeNode 종료

    private TreeNode root;  // 문자열의 이진 트리에서 루트 노드를 나타내는 포인터.
    // 이 트리는 프로그램에서 이진 정렬 트리로 사용됩니다.
    // 트리가 비어 있으면 루트는 null입니다 (초기에는 그렇습니다).

    public TreeNode getRoot() {
        return root;
    }

    public void storedStringsInBinarySortTree() {

        String word = "";
        while (! TextIO.eof()) {
            word = ReadFile.readNextWord();
            if (word != null && ! treeContains(root, word.toLowerCase())) {
                treeInsert(word.toLowerCase());
            }
        }
    }

    // 중위 순회 inOrder : Left -> Root -> Right
    public void writeBinarySortTree(TreeNode node) {
        if (node != null) {
            if (node.left != null) writeBinarySortTree(node.left);             // Print items in left subtree.
            TextIO.putln(node.item);        // Print item in the node.
            if (node.right != null) writeBinarySortTree(node.right);          // Print items in the right subtree.
        }
    }


    /**
     * 전역 변수 "root"가 참조하는 이진 정렬 트리에 항목을 추가합니다.
     * (참고: root는 매개변수로 전달할 수 없습니다.
     * root의 값이 변경될 수 있기 때문에 형식 매개변수의 값이 변경되면 실제 매개변수가 변경되지 않습니다.)
     */
    public void treeInsert(String newItem) {
        if (root == null) {
            // 트리가 비어 있습니다. root를 새 항목을 포함하는 새 노드를 가리키도록 설정합니다.
            // 이것이 트리의 유일한 노드가 됩니다.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;  // newItem을 위해 장소를 찾아가는 데 사용됩니다.
        runner = root;   // root에서 시작합니다.
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {
                // 새 항목이 runner의 항목보다 작으므로,
                // runner의 왼쪽 서브 트리에 속합니다.
                // runner.left에 공간이 있다면 거기에 새 노드를 추가합니다.
                // 그렇지 않으면 왼쪽으로 한 수준 내려가 runner를 진행합니다.
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;  // 새 항목이 트리에 추가되었습니다.
                } else
                    runner = runner.left;
            } else {
                // 새 항목이 runner의 항목보다 크거나 같으므로,
                // runner의 오른쪽 서브 트리에 속합니다.
                // runner.right에 공간이 있다면 거기에 새 노드를 추가합니다.
                // 그렇지 않으면 오른쪽으로 한 수준 내려가 runner를 진행합니다.
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;  // 새 항목이 트리에 추가되었습니다.
                } else
                    runner = runner.right;
            }
        } // 종료 while
    }  // 종료 treeInsert()

    /**
     * 항목이 root가 가리키는 이진 트리의 항목 중 하나인 경우 true를 반환합니다.
     * 그렇지 않으면 false를 반환합니다.
     */
    public boolean treeContains(TreeNode root, String item) {
        if (root == null) {
            // 트리가 비어 있으므로 항목을 포함하지 않습니다.
            return false;
        } else if (item.equals(root.item)) {
            // 예, 항목이 루트 노드에서 찾아졌습니다.
            return true;
        } else if (item.compareTo(root.item) < 0) {
            // 항목이 발생하면 왼쪽 서브 트리에 있어야 합니다.
            return treeContains(root.left, item);
        } else {
            // 항목이 발생하면 오른쪽 서브 트리에 있어야 합니다.
            return treeContains(root.right, item);
        }
    }  // 종료 treeContains()

    /**
     * 이진 트리의 노드 수를 세어 반환합니다.
     *
     * @param node 트리의 루트를 가리키는 포인터입니다.
     *             null 값은 비어 있는 트리를 나타냅니다.
     * @return 노드가 가리키는 트리의 노드 수입니다.
     * 비어 있는 트리의 경우 값은 0입니다.
     */
    private int countNodes(TreeNode node) {
        if (node == null) {
            // 트리가 비어 있으므로 노드를 포함하지 않습니다.
            return 0;
        } else {
            // 루트 노드 및 그 두 서브 트리의 노드를 추가합니다.
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    } // 종료 countNodes


    /**
     * 트리의 항목을 중위 순서로 한 줄에 하나씩 출력합니다.
     * 트리가 정렬 트리이기 때문에 출력은 증가하는 순서로 될 것입니다.
     */
    private void printTreeList(TreeNode node) {
        if (node != null) {
            printTreeList(node.left);             // 왼쪽 서브 트리의 항목을 출력합니다.
            System.out.println("  " + node.item);  // 노드의 항목을 출력합니다.
            printTreeList(node.right);            // 오른쪽 서브 트리의 항목을 출력합니다.
        }
    } // 종료 treeList()

    public void printBinarySortTreeByRecursion() {
        System.out.println("\n트리에는 " + countNodes(root) + "개의 항목이 있습니다.");
        System.out.println("\n트리 내용:\n");
        printTreeList(root);
    }

    // 9_4 번에서 활용되는 비재귀적 방식으로 이진 트리 항목을 인쇄하는 메서드 (큐 사용)
    public void printBinartSortTreeUsingQueue() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.println(" " + currentNode.item);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
} // 종료 class BinarySortTree