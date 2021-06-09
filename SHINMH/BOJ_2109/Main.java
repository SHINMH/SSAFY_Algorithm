package BOJ_2109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10001];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o2[0] - o1[0];
        });

        LinkedList<int[]> list = new LinkedList<>();

        //0 : money, 1 : day
        int maxDay = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            maxDay = Math.max(day, maxDay);
            list.add(new int[]{money, day});
        }

        list.sort((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });

        int answer = 0;
        while(maxDay > 0){
            while(!list.isEmpty() && maxDay == list.peek()[1]){
                priorityQueue.add(list.pop());
            }
            if (!priorityQueue.isEmpty()) answer += priorityQueue.poll()[0];
            maxDay--;
        }

        System.out.println(answer);
    }
}
