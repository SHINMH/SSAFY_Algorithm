package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_12865 {
	private static class Obj {
		int w, v;

		public Obj(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

	}
	private static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		Obj[] obj = new Obj[N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int weight = Integer.parseInt(input[0]);
			int value = Integer.parseInt(input[1]);
			obj[i] = new Obj(weight, value);
		}
		dp = new int[N + 1][K + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				 if(obj[i-1].w <= j)
					 dp[i][j] = Math.max(dp[i-1][j], obj[i-1].v+dp[i-1][j-obj[i-1].w]);
				 else
					 dp[i][j] = dp[i-1][j];
			}
		}
		for(int i = 1;i<=N;i++) 
			max=Math.max(max,dp[i][K]);
		System.out.println(max);
	}
}
