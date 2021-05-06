package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));
		int curr = 0, res = 0; // curr : 현재 비교 값  res : 최종 비교 값
		for (int i = 0; !pq.isEmpty(); i++) {
			if (i % 2 == 1) { // 2번째 카드를 pq에서 그 다음 최소값을 뽑아내서 curr에 더해주고 현재까지 비교 회수를 res에 넣어주고 다시 pq에 넣어준다.
				curr += pq.poll();
				res += curr;
				pq.offer(curr);
			} 
			else curr = pq.poll(); // 1번째 카드 pq에서 최소값을 뽑아내서 curr에 넣어줌
		}
		System.out.println(res);
	}
}