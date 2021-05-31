package chp22;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Monali L on 5/31/2021
 */

public class ITA_22_2_BreadthFirst {

    private int[][] weight;

    public static void main(String[] args) {
        int[][] w = {
                {0, 5, 7, 0},
                {0, 0, 0, 1},
                {11, 7, 0, 0},
                {0, 0, 0, 0}
        };
        ITA_22_2_BreadthFirst obj = new ITA_22_2_BreadthFirst();
        obj.weight = w;
        obj.BreadthFirst(0);
    }

    public void BreadthFirst(int root) {
        // private int[] vertex;
        boolean[] isVisited = new boolean[weight.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (!isVisited[curr]) {
                System.out.println(curr);
                isVisited[curr] = true;
                for (int i = 0; i < weight.length; i++) {
                    if (i == curr) continue;
                    if (weight[curr][i] > 0 && !isVisited[i]) {
                        queue.add(i);
                        isVisited[i] = true;
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
