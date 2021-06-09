package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_1082_방번호 {
	private static int N, K, max_cnt = 0;
	private static int[] arr;
	private static String[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
		K = Integer.parseInt(br.readLine());
        dp = new String[K+1][K+1];
		dfs(0, 0, new String("")); // dfs 시작
		String ans = "";
		for (int i = K; i >= 0; i--) // 최대 자리 수 중 가장 큰 수 탐색
			if (dp[max_cnt][i] != null) 
				if(ans.compareTo(dp[max_cnt][i]) < 0) ans = dp[max_cnt][i];
		System.out.println(ans);
	}
	private static void dfs(int cnt, int sum, String number) { //cnt : 현재 자리 수 sum : 현재까지 사용한 금액 number : 현재까지 구매한 방 번호
		if (sum > K) return; // 현재까지 사용한 금액이 한도를 초과하면 return
		if (dp[cnt][sum] != null) return; // dp에 이미 저장되어있다면 큰 수부터 탐색을 했기 때문에 현재 number는 무조건 저장되어 있는 값보다 작다. 따라서 return
		dp[cnt][sum] = number; // dp에 저장되어있지 않다면 sum 금액을 지불했을 때 만들 수 있는 cnt 자리 수의 최댓값인 number을 넣어준다.
		max_cnt = Math.max(max_cnt, cnt); // 현재까지 만든 방 번호 중 가장 큰 자리 수를 저장
		if (cnt > 0 && number.charAt(0) == '0') return; // 첫 자리가 0이면 다음 자리 수를 가져올 수 없으므로 return
		for (int i = N - 1; i >= 0; i--) dfs(cnt + 1, sum + arr[i], number + i); // 큰 수부터 dfs
	}
}