package SSAFY_Algorithm.Queue.BOJ_15903;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ParkSeRyeong {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/stack_queue/card_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String tmp = br.readLine();
		int n = Integer.parseInt(tmp.split(" ")[0]);
		int m = Integer.parseInt(tmp.split(" ")[1]);
		PriorityQueue<Long> q = new PriorityQueue<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			q.offer(Long.valueOf(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			long combination = q.poll() + q.poll();
			q.offer(combination);
			q.offer(combination);
		}

		long sum = 0;
		while (!q.isEmpty()) {
			sum += q.poll();
		}
		bw.write(String.valueOf(sum));

		br.close();
		bw.flush();
		bw.close();
	}
}
