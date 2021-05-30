package all;

import java.util.Arrays;

/**
 * @author Monali L on 5/27/2021
 */
public class Temp {

    public static void main(String[] args) {
        Temp object = new Temp();

        int[] input1 = {0, 1, 2, 3, 0};
        System.out.println("minSideJumps input1 - " + object.minSideJumps(input1));
        System.out.println();

        int[] input2 = {0,1,1,3,3,0};
        System.out.println("minSideJumps input2 - " + object.minSideJumps(input2));
        System.out.println();

        int[] input3 = {0,2,1,0,3,0};
        System.out.println("minSideJumps input3 - " + object.minSideJumps(input3));
        System.out.println();

        int[] input4 = {0,0,3,1,0,1,0,2,3,1,0};
        System.out.println("minSideJumps input4 - " + object.minSideJumps(input4));
        System.out.println();

        int[] input5 = {0,0,2,0,0,0,2,1,2,0,0};
        System.out.println("minSideJumps input5 - " + object.minSideJumps(input5));
        System.out.println();
    }

    private int[][] dp;

    public int minSideJumps(int[] obstacles) {
        dp = new int[4][obstacles.length];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(dp[i], -1);
        }
        int jumps = helper2(obstacles, 2, 0);
                // helper(obstacles, 2, 0, 0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                System.out.print(String.format("%3d", dp[i][j]));
            }
            System.out.println();
        }
        return jumps;
    }

    private int helper2(int[] ob, int lane, int pos) {
        if (pos == ob.length-1) return 0;
        if (ob[pos] == lane) return Integer.MAX_VALUE;
        if (dp[lane][pos] != -1) return dp[lane][pos];
        if (ob[pos+1] != lane) {
            dp[lane][pos] = helper2(ob, lane, pos+1);
        } else {
            int minJumps = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (i == lane) continue;
                minJumps = Math.min(minJumps, helper2(ob, i, pos));
            }
            dp[lane][pos] = 1 + minJumps;
        }
        return dp[lane][pos];
    }
}
