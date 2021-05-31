package chp22;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Monali L on 5/31/2021
 */

public class ITA_22_3_DepthFirst {

    private boolean[] isVisited;
    private int[][] weight;
    private Stack<Integer> stack;

    ITA_22_3_DepthFirst() {
        weight = new int[][]{
                {0, 5, 7, 0},
                {0, 0, 0, 1},
                {11, 7, 0, 0},
                {0, 0, 0, 0}
        };;
        isVisited = new boolean[weight.length];
        stack = new Stack<Integer>();
    }

    public void dfs(int v) {
        System.out.println(v);
        isVisited[v] = true;
        for (int i = 0; i < weight.length; i++) {
            if (i == v) continue;
            if (weight[v][i] > 0 && !isVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        ITA_22_3_DepthFirst obj = new ITA_22_3_DepthFirst();
        obj.dfs(0);
    }
}
