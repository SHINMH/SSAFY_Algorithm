package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter; 
import java.util.StringTokenizer;

public class BOJ_2916 {
	static int N;
	static long min = Long.MAX_VALUE;
	static int[][] material;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		material = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			material[i][0] = Integer.parseInt(st.nextToken());
			material[i][1] = Integer.parseInt(st.nextToken());
		}
		combination(0, 0, 1, 0);
		bw.write(String.valueOf(min));
		bw.close();
	}

	static void combination(int toSelect, int startIdx, long sour, long bitter) {
		if (toSelect > 0)
			min = Math.min(min, Math.abs(bitter - sour));
		if (toSelect == N)
			return;
		for (int i = startIdx; i < N; i++)
			combination(toSelect + 1, i + 1, material[i][0] * sour, material[i][1] + bitter);
	}
}
