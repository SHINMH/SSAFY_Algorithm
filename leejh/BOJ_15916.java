package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int D = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		int C = Integer.parseInt(input[3]);
		int[] sushi = new int[N], s = new int[D + 1];
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		int answer = 0;
		int cnt = 1;
		s[C]++;
		for (int i = 0; i < K; i++) {
			if (s[sushi[i]] == 0)
				cnt++;
			s[sushi[i]]++;
		}
		for (int i = 0; i < sushi.length; i++) {
			if (s[sushi[(i + K) % sushi.length]] == 0) cnt++;
			s[sushi[(i + K) % sushi.length]]++;
			s[sushi[i]]--;
			if (s[sushi[i]] == 0) cnt--;
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
}
