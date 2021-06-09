package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17494 {
	static class Snack implements Comparable<Snack> {
		int W;
		int H;

		Snack(int W, int H) {
			this.W = W;
			this.H = H;
		}

		@Override
		public int compareTo(Snack o) {
			if (this.W == o.W)
				return this.H - o.H;
			return this.W - o.W;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		boolean Flag = false;
		int maxWeight = 0;
		Snack[] snack = new Snack[N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			snack[i] = new Snack(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			maxWeight += snack[i].W;
		}
		Arrays.sort(snack);
		int[][][] dp = new int[N + 1][maxWeight + 1][2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				if (j >= snack[i - 1].W) {
					dp[i][j][0] = dp[i - 1][j - snack[i - 1].W][0] + snack[i - 1].H;
					dp[i][j][1] = dp[i - 1][j - snack[i - 1].W][1] + snack[i - 1].W;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = M; j <= maxWeight; j++) {
				if (dp[i][j][0] != 0 && dp[i][j][1] >= M)
					min = Math.min(min, dp[i][j][0]);
			}
		}
		System.out.println(min);
	}
}
