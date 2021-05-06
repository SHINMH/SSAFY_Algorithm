package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14888 {
	private static long min= Long.MAX_VALUE,max= Long.MAX_VALUE*-1;
	private static int N;
	private static int[] exprs, nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		nums = new int[N]; // 정수들 저장
		exprs = new int[N - 1]; // 연산자 저장
		int[] expr = new int[4]; //+-*/ 순으로 개수 저장

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = 0;
		for (int i = 0; i < 4; i++) { // 연산자 개수 입력
			expr[i] = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + expr[i]; j++)// 각 연산자를 배열에 개수만큼씩 나열해줌
				exprs[j] = i;
			x += expr[i];
		}

		permutations(0, 0, "");
		bw.write(max + "\n" + min);
		bw.close();
	}

	private static void permutations(int cnt, int flag, String exp) {
		if (cnt == N - 1) { // 연산자 조합이 끝났을 시 조합된 식을 계산
			long res = nums[0];
			for (int i = 0, j = 1; i < N - 1; i++, j++) {
				res = calc(res, nums[j], exp.charAt(i));
			min = Math.min(min, res); // 최댓값
			max = Math.max(max, res); // 최솟값
		}
			return;
		}
		for (int i = 0; i < N - 1; ++i) {
			if ((flag & 1 << i) != 0) continue;
			permutations(cnt + 1, flag | 1 << i, exp + String.valueOf(exprs[i]));
		}

	}

	private static long calc(long a, int b, char exp) { // 연산 실행
		switch (exp) {
		case '0': return a + b;
		case '1': return a - b;
		case '2': return a * b;
		case '3': return a / b;
		default: return 0;
		}
	}
}
