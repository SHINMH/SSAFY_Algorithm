package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4883 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int tc = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int[][] dp = new int[N][3]; // N*3 행렬 생성
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				if (i == 0) {
					dp[0][0] = dp[0][1] = y; // 첫째줄의 맨 왼쪽은 사용될 수 없는 값이므로 가운데와 동일하게 넣어줌
					dp[0][2] = y + z; // 가운데를 거쳐 왔으므로 y+z
				}

				else { // 들어올 수 있는 수 중 가장 작은 값과 합산
					dp[i][0] = x + Math.min(dp[i - 1][0], dp[i - 1][1]); 
					dp[i][1] = y + Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])));
					dp[i][2] = z + Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
				}
			}
			bw.write(tc + ". " + dp[N - 1][1] + "\n");
			tc++;
		}
		bw.close();
	}
}