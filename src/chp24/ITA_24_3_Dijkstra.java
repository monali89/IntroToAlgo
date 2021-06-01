package chp24;

import all.Temp;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Monali L on 6/1/2021
 */

public class ITA_24_3_Dijkstra {

    private double[][] adj;
    private double[] dist;
    private int[] prev;
    private PriorityQueue<Integer> pq;
    private int n;
    private boolean[] isVisited;

    ITA_24_3_Dijkstra() {
        adj = new double[][]{
                {0, 10, 5, 0, 0},
                {0, 0, 2, 1, 0},
                {0, 3, 0, 9, 2},
                {0, 0, 0, 0, 4},
                {7, 0, 0, 6, 0}
        };
        n = adj.length;
        isVisited = new boolean[n];
    }

    public void djk() {
        dist = new double[n];
        prev = new int[n];
        pq = new PriorityQueue<Integer>(n, new DistanceComparator());

        for (int i = 1; i < n; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            prev[i] = -1;
            pq.add(i);
        }
        dist[0] = 0;
        pq.add(0);

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
            System.out.printf("%s | %s | %2s", i, prev[i], dist[i]);
            System.out.println();
        }
        System.out.println();
    }

    public class DistanceComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (int) (dist[o2] - dist[o1]);
        }
    }

    public static void main(String[] args) {
        ITA_24_3_Dijkstra obj = new ITA_24_3_Dijkstra();
        obj.djk();
    }
}
