package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BOJ_14226 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 3];
		Arrays.fill(dp, 99999);
		dp[1] = 0;
		for (int i = 1; i <= N + 2; i++) { 
			for (int j = 2; i * j <= N + 2; j++) // 배수 set
				dp[i * j] = Math.min(dp[i * j], dp[i] + j);
			for (int j = N + 1; j >= 2; j--) // 삭제 set
				dp[j] = Math.min(dp[j], dp[j + 1] + 1);
		}
		System.out.println(dp[N]);
		for(int i = 1; i<N+1;i++)System.out.println(i+" "+dp[i]);
	}
}