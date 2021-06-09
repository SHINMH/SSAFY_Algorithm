package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10830 {
	private static HashMap<Long, int[][]> dp;// A^b 행렬 저장
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Long b = Long.parseLong(st.nextToken());

		dp = new HashMap<>(); // A^b 행렬 저장
		int[][] map = new int[n][n];
		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < n; col++)
				map[row][col] = Integer.parseInt(st.nextToken())%1000;
		}
		dp.put(1L, map); // A^1 행렬 저장
		distribution_cal(n, b);
		map = dp.get(b); // A^b 행렬 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				bw.write(map[i][j] + " ");
			bw.write("\n");
		}
		bw.close();
	}

	private static int[][] distribution_cal(int n, Long b) {
		if (b == 1) { // 지수가 1일 때 dp[1] return
			return dp.get(1L);
		} else if (dp.getOrDefault(b, null) != null) { //이미 계산된 A^b 행렬일 경우
			return dp.get(b);
		} else { // 계산되지 않은 A^b행렬
			int[][] res = new int[n][n];
			if ((b % 2) == 1) { // b가 홀수일때 A^(b-1) * A 실행
				int[][] arr = distribution_cal(n, b - 1); 
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++)
							res[i][j] += (arr[i][k] * dp.get(1L)[k][j]);
						res[i][j] %= 1000;
					}
			} else { // b가 짝수일 때 A^(b/2)*A^(b/2) 실행
				int[][] arr = distribution_cal(n, b / 2);
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++)
							res[i][j] += (arr[i][k] * arr[k][j]);
						res[i][j] %= 1000;
					}
			}
			dp.put(b, res); // b를 key로 set에 값 저장
			return res;
		}
	}
}
