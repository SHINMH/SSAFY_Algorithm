package BOj_1647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int value;

        public Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }

    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        parent = new int[N + 1];

        int from, to, value;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Edge(from, to, value));
//            edges[i] = new Edge(from, to, value);
        }
        // 배열 정렬
//        Arrays.sort(edges);
        // 집합 생성
        makeSet();

        int result = 0;
        int count = 0;
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(union(edge.from, edge.to)){
                result += edge.value;
                if(N - 2 == ++count) break;
            }
        }
//        for(Edge edge : edges){
//            if(union(edge.from, edge.to)){
//                result += edge.value;
//                if(N - 2 == ++count) break;
//            }
//        }

        System.out.println(result);
    }

    public static void makeSet(){
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
    }

    public static boolean union(int from, int to){
        int fromRoot = findSet(from);
        int toRoot = findSet(to);
        if(fromRoot == toRoot) return false;
        parent[toRoot] = fromRoot;
        return true;
    }

    public static int findSet(int edge){
        if(parent[edge] == edge) return edge;
        return parent[edge] = findSet(parent[edge]);
    }
}
