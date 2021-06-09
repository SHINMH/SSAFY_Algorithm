package BOJ_1753;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10000000;

    static class Element implements Comparable<Element> {
        int node;
        int dist;

        Element(int node, int dist) {

            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Element o) {
            return this.dist < o.dist ? -1 : 1;
        }

        @Override
        public String toString() {
            return "node=" + node + ", dist=" + dist;
        }
    }

    public static void main(String[] args) throws IOException {
        int V;
        int E;
        int[][] W;
        int[] dist;
        int startNode;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        W = new int[V + 1][V + 1];
        dist = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            Arrays.fill(W[i], INF);
            Arrays.fill(dist, INF);
        }

        startNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            W[a][b] = W[a][b] > w ? w : W[a][b];
        }

        dijkstra(startNode, V, W, dist);

        for (int i = 1; i < V + 1; i++) {

            bw.write(dist[i] < INF ? dist[i] + "\n" : "INF\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int src, int V, int[][] W, int[] dist) {
        PriorityQueue<Element> pq = new PriorityQueue<>();

        dist[src] = 0;

        pq.add(new Element(src, dist[src]));

        while (!pq.isEmpty()) {
            int cost = pq.peek().dist;
            int here = pq.peek().node;

            pq.poll();

            if (dist[here] < cost) {
                continue;
            }

            for (int i = 1; i < V + 1; i++) {
                if (W[here][i] < INF) {
                    if (dist[i] > dist[here] + W[here][i]) {
                        dist[i] = dist[here] + W[here][i];
                        pq.add(new Element(i, dist[i]));
                    }
                }
            }
        }
    }
}
