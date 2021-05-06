package leejh;

/*
 *[BOJ_2281] 데쓰노트 - DP 문제
 *
 * - 조건 -
 * 1. n명의 이름을 순서대로!!! 데스노트에 적는다.
 * 2. 한 명의 이름 뒤에는 공백을 무조건 포함해야한다.
 * 3. 줄의 끝에서 A의 이름이 끊기면 A의 이름은 현재 줄이 아닌 다음 줄에 적어야한다.
 * 4. 맨 끝 줄의 오른쪽 여백은 고려하지 않는다.
 * 
 * - 구현  -
 * Ex) A -> 현재 적을 이름
 * 1. A를 다음 줄에 적는 경우
 * 2. A를 현재 줄 뒤에 적을 수 있는 경우
 * 3. dp[index][length] --> index : 현재 적을 이름, length : 현재 이름의 칸 위치
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2281 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
        
		int names[] = new int[N];
		for (int i = 0; i < N; i++)
			names[i] = Integer.parseInt(br.readLine());
		int dp[][] = new int[N][M + 2];
		for(int[] a : dp) Arrays.fill(a, -1);
		System.out.println(dfs(dp,names,N,M,1,names[0]+1));
	}

	private static int dfs(int[][] dp, int[] names, int N, int M, int index, int length) {
		if (index == N) // 마지막 줄 공백 고려 X
			return 0;
		if (dp[index][length] != -1) // 이미 계산된 자리라면 dp에 저장된 값을 return
			return dp[index][length];
		dp[index][length] = (M - length + 1) * (M - length + 1) + dfs(dp,names,N,M,index + 1, names[index] + 1); // 현재 자리에 이름을 적었을 때 공백 값
		if (length + names[index] <= M) // 현재 줄에 이름을 더 적을 수 있다면 다음 줄로 넘겼을 때의 값과 다음 칸에 썼을 경우의 값 중 최소값을 dp에 저장
			dp[index][length] = Math.min(dp[index][length], dfs(dp,names,N,M,index + 1, length + names[index] + 1));
		return dp[index][length];
	}
}
