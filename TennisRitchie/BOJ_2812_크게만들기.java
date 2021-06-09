package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
public class BOJ_2812_크게만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		String number = br.readLine();
		int cnt = 0; // 제거한 수의 개수
		Deque<Character> dq = new LinkedList<>();
		dq.offer(number.charAt(0)); // 첫번째 글자를 deque에 넣고 시작
		for (int i = 1; i < N; i++) {
			char curr = number.charAt(i);
			while (!dq.isEmpty()) { // 제거한 수의 개수가 K개를 넘지 않고 deque에서 top에 있는 값이 현재 값보다 같을 때까지 pop함
				if (cnt < K && dq.peekFirst() < curr) {
					cnt++;
					dq.pop();
				} else  break;
			}
			if (dq.size() == N - K) break; // 현재 deque에 들어가 있는 글자의 수가 N-K개를 만족한다면 더 이상 수를 제거하지않고 그대로 출력한다.  
			dq.push(curr);
		}
		while (!dq.isEmpty()) bw.write(dq.pollLast());
		bw.close();
	}
}