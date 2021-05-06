package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {
	private static int m, n;
	private static PriorityQueue<Long> pq; // 카드 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 카드 수 
		m = Integer.parseInt(st.nextToken()); // 합체 횟수
		
		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n;i++) pq.add(Long.parseLong(st.nextToken())); // 카드 입력
		for(int i = 0; i<m;i++) {
			Long temp = pq.poll() + pq.poll(); // 작은 2개의 카드를 꺼내서 더하고 더한 수로 넣어줌
			pq.add(temp);
			pq.add(temp);
		}
		long res = 0L;
		while(!pq.isEmpty()) res += pq.poll(); // 합체 과정이 끝난 후 카드에 써있는 수를 다 더함
		bw.write(String.valueOf(res));
		bw.close();
	}
}
