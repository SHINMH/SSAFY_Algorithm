package BOJ_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge>{
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Edge>[] list = new LinkedList[V + 1];
        for(int i = 1; i <= V; i++){
            list[i] = new LinkedList<>();
        }

        int start, end, weight;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(end, weight));
            list[end].add(new Edge(start, weight));
        }

        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(1, 0));

        int sum = 0, minVertex;
        while(!priorityQueue.isEmpty()){
            Edge current = priorityQueue.poll();
            if(visited[current.node]) continue;
            visited[current.node] = true;
            sum += current.weight;

            for(Edge ob : list[current.node]){
                if(!visited[ob.node] && distance[ob.node] > ob.weight){
                    distance[ob.node] = ob.weight;
                    priorityQueue.add(ob);
                }
           }
        }
        System.out.println(sum);
    }
}
