package all;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Temp {

    private double[][] adj;
    private double[] dist;
    private int[] prev;
    private PriorityQueue<Integer> pq;
    private int restrictedPaths;
    private int end;

    enum Color {
        WHITE,
        GREY,
        BLACK
    }
    private Color[] mark;

    public int countRestrictedPaths(int n, int[][] edges) {

        restrictedPaths  = 0;
        end = n;

        // initialize graph
        adj = new double[n][n];
        for (int[] e: edges) {
            adj[e[0]-1][e[1]-1] = e[2];
            adj[e[1]-1][e[0]-1] = e[2];
        }

        // Dijkstra to calculate min distances
        dijkstra(n);

        // dfs to get the paths
        boolean[] isVisited = new boolean[n];
        dfs(0, isVisited);

        return restrictedPaths % 1000000007;
    }

    public void dfs(int u, boolean[] isVisited) {
        isVisited[u] = true;
        if (u == end-1) {
            restrictedPaths++;
            return;
        }
        for (int v = 0; v < adj[u].length; v++) {
            if (v == u || adj[v][u] == 0) continue;
            if (!isVisited[v] && v > u && dist[v] < dist[u]) {
                dfs(v, isVisited);
                isVisited[v] = false;
            }
        }
    }

    public void dijkstra(int n) {
        dist = new double[n];
        prev = new int[n];
        pq = new PriorityQueue<Integer>(n, new DistanceComparator());
        mark = new Color[n];
        Arrays.fill(mark, Color.WHITE);

        for (int i = 0; i < n-1; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            prev[i] = -1;
            pq.add(i);
        }
        dist[n-1] = 0;
        pq.add(n-1);

        while (!pq.isEmpty()) {
            int u = pq.remove();
            mark[u] = Color.GREY;
            for (int v = 0; v < adj[u].length; v++) {
                if (v == u || adj[u][v] == 0 || mark[v] == Color.BLACK) continue;
                if (dist[v] > (dist[u] + adj[u][v])) {
                    pq.remove(v);
                    dist[v] = dist[u] + adj[u][v];
                    prev[v] = u;
                    pq.add(v);
                }
            }
            mark[u] = Color.BLACK;
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.printf("%s | %s | %2s", i, prev[i], dist[i]);
            System.out.println();
        }
    }

    public class DistanceComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (int) (dist[o1] - dist[o2]);
        }
    }

    public static void main(String[] args) {
        Temp object = new Temp();

        /*int n = 5;
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};*/

        /*int n = 7;
        int[][] edges = {{1,3,1},{4,1,2},{7,3,4},{2,5,3},{5,6,1},{6,7,2},{7,5,3},{2,6,4}};*/

        int n = 9;
        int[][] edges = {{6,2,35129},{3,4,99499},{2,7,43547},{8,1,78671},{2,1,66308},
                {9,6,33462},{5,1,48249},{2,3,44414},{6,7,44602},{1,7,14931},{8,9,38171},
                {4,5,30827},{3,9,79166},{4,8,93731},{5,9,64068},{7,5,17741},{6,3,76017},
                {9,4,72244}};

        System.out.println("restrictedPaths: " + object.countRestrictedPaths(n, edges));
    }
}
