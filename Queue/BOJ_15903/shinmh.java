package SSAFY_Algorithm.Queue.BOJ_15903;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class shinmh {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			priorityQueue.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i = 0; i < M; i++) {
			long num1 = priorityQueue.poll();
			long num2 = priorityQueue.poll();
			
			priorityQueue.add(num1 + num2);
			priorityQueue.add(num1 + num2);
		}
		
		long sum = 0;
		while(!priorityQueue.isEmpty()) {
			sum += priorityQueue.poll();
		}
		System.out.println(sum);
	}
}
