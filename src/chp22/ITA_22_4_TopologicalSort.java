package chp22;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Monali L on 5/31/2021
 */

public class ITA_22_4_TopologicalSort {

    private int[][] weight;
    private Stack<Integer> stack;
    private char[] mark;

    private static final char UNMARKED = 'u';
    private static final char TEMPORARY = 't';
    private static final char PERMANENT = 'p';

    ITA_22_4_TopologicalSort() {
        weight = new int[][]{
                {0, 5, 7, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 5, 0}
        };;
        mark = new char[weight.length];
        Arrays.fill(mark, UNMARKED);
        stack = new Stack<Integer>();
    }

    public void topSort() {
        for (int i = 0; i < weight.length; i++) {
            if (mark[i] == UNMARKED) {
                dfs(i);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void dfs(int v) {

        if (mark[v] == PERMANENT) return;
        if (mark[v] == TEMPORARY) {
            try {
                throw new InvalidArgumentException(null);
            } catch (InvalidArgumentException e) {
                System.out.println("Not a DAG");
                e.printStackTrace();
            }
        }

        mark[v] = TEMPORARY;

        for (int i = 0; i < weight.length; i++) {
            if (i == v) continue;
            if (weight[v][i] > 0) dfs(i);
        }
        mark[v] = PERMANENT;
        stack.push(v);
    }

    public static void main(String[] args) {
        ITA_22_4_TopologicalSort obj = new ITA_22_4_TopologicalSort();
        obj.topSort();
    }
}
