package all;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Temp {

    public static void main(String[] args) {
        Temp object = new Temp();
        int n = 5;
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
        System.out.println("restrictedPaths - " + object.countRestrictedPaths(n, edges));
    }

    private double[][] adj;
    private double[] dist;
    private int[] prev;
    private PriorityQueue<Integer> pq;
    private int restrictedPaths;
    private int end;

    public int countRestrictedPaths(int n, int[][] edges) {

        restrictedPaths  = -1;
        end = n;

        // initialize graph
        adj = new double[n][n];
        for (int[] e: edges) {
            adj[e[0]-1][e[1]-1] = e[2];
        }

        // Dijkstra to calculate min distances
        dijkstra(n);

        // dfs to get the paths
        boolean[] isVisited = new boolean[n];
        dfs(1, isVisited);

        return restrictedPaths;
    }

    public void dfs(int u, boolean[] isVisited) {
        isVisited[u] = true;
        if (u == end) {
            restrictedPaths++;
            return;
        }
        for (int v = 0; v < adj[u].length; v++) {
            if (v == u) continue;
            if (!isVisited[v] && v > u) {
                dfs(v, isVisited);
            }
        }
    }

    public void dijkstra(int n) {
        dist = new double[n];
        prev = new int[n];
        pq = new PriorityQueue<Integer>(n, new DistanceComparator());

        for (int i = 0; i < n; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            prev[i] = -1;
            pq.add(i);
        }
        dist[end-1] = 0;

        while (!pq.isEmpty()) {
            int u = pq.remove();
            for (int v = 0; v < adj[u].length; v++) {
                if (v == u || adj[u][v] == 0) continue;
                if (dist[v] > (dist[u] + adj[u][v])) {
                    pq.remove(v);
                    dist[v] = dist[u] + adj[u][v];
                    prev[v] = u;
                    pq.add(v);
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public class DistanceComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return (int) (dist[o2] - dist[o1]);
        }
    }
}
