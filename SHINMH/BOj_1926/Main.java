package BOj_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Bus {
        int to;
        int pay;

        public Bus(int to, int pay) {
            this.to = to;
            this.pay = pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Bus>[] list = new LinkedList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new LinkedList<Bus>();
        }

        StringTokenizer st;
        int from, to, pay;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            pay = Integer.parseInt(st.nextToken());

            list[from].add(new Bus(to, pay));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for(int c = 0; c < N; c++){
            int minVertex = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= N; i++){
                if(!visited[i] && min > distance[i]){
                    min = distance[i];
                    minVertex = i;
                }
            }

            visited[minVertex] = true;
            if(minVertex == end) break;

            for(Bus bus : list[minVertex]){
                if(!visited[bus.to] && distance[bus.to] > bus.pay + min){
                    distance[bus.to] = bus.pay + min;
                }
            }
        }

        System.out.println(distance[end]);
    }
}
