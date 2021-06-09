package BOJ_1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        long sum = 0;
        for(int i = 0; i < N; i++){
            priorityQueue.add(Long.parseLong(br.readLine()));
        }

        while(priorityQueue.size() > 1){
            long count = priorityQueue.poll() + priorityQueue.poll();
            priorityQueue.add(count);
            sum += count;
        }

        System.out.println(sum);
    }
}
