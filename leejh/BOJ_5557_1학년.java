package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5557_1학년 {
	private static int N;
	private static int[] arr;
	private static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new long[21][N]; // 결과값까지 도달하는데 사용된 수의 개수에서 등식을 만족시키는 식의 개수를 저장
		for (int i = 0; i < 21; i++) Arrays.fill(dp[i], -1L); // dummy 변수인 -1로 setting
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		System.out.println(dfs(arr[0], 0));
	}
	private static long dfs(int res, int cnt) {
		if (res > 20 || res < 0) return 0; // 더한 수는 무조건 0이상 20이하이기 때문에 예외처리
		if (cnt == N - 2) { // 등호 전까지 도달했고
			if (res == arr[N - 1]) return 1; // 좌변과 우변이 같으면 개수 1개 return
			return 0; // 다르면 0 return
		}
		if (dp[res][cnt] != -1L) return dp[res][cnt]; //이미 연산된 dp 값이라면 그대로 return
		dp[res][cnt] = 0L; // dp가 -1이었으므로 연산을 위해 0으로 재 초기화
		// dp[res][cnt]에 값은 뒤의 수를 더하고 뺀 경우의 수의 합
		return dp[res][cnt] = dfs(res + arr[cnt + 1], cnt + 1) + dfs(res - arr[cnt + 1], cnt + 1);
	}
}
