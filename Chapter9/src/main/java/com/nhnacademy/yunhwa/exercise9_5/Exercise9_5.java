package com.nhnacademy.yunhwa.exercise9_5;

import java.util.Random;

/*
* 하위 섹션 9.4.2 에서는
* 이진 정렬 트리가 무작위 순서로 항목을 삽입하여 생성된 경우
* 트리가 대략 균형을 이룰 확률이 높습니다." 라는 주장이 있다.
* 이것이 사실인지 테스트하기 위해 실험을 수행하는 프로그램
* */
public class Exercise9_5 {

    public static void main(String[] args) {
        TreeNodes treeNodes = makeRandomBinarySortTreeWith1023Nodes(100);
        treeNodes.printTreeList(treeNodes.getRoot());
        treeNodes.makeDepthListOfAllTheLeaves(treeNodes.getRoot(), 0, 0);
        System.out.println("=======================");
        System.out.printf("모든 리프들의 평균 깊이 : %d%n", treeNodes.averageDepthOfAllTheLeaves());
        System.out.printf("모든 리프들 중 최대 깊이 : %d%n", treeNodes.maxDepthOfAllTheLeaves());
    }

    public static TreeNodes makeRandomBinarySortTreeWith1023Nodes(int maxRandom) {
        // 실수 랜덤 num 생성하고 treeInsert() 로 트리에 삽입하여 트리 생성
        TreeNodes treeNodes = new TreeNodes();

        Random random = new Random();
        double randomDouble;
        for (int i = 0; i < 1023; i++) {
            randomDouble = random.nextDouble() * maxRandom + 1 ; // 1부터 maxRandom 까지 난수 생성
            treeNodes.treeInsert(randomDouble);
        }

        return treeNodes;
    }
}