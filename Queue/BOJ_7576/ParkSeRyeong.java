package SSAFY_Algorithm.Queue.BOJ_7576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ParkSeRyeong {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/stack_queue/tomato_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int[][] arr = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();

		int zeros = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.offer(new int[] { i, j, 0 });
				} else if (arr[i][j] == -0) {
					zeros++;
				}
			}
		}

		int min_change_cnt = 0;
		int changedZero = 0;
		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			min_change_cnt = q.peek()[2] + 1;

			q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) continue;
				if (arr[nr][nc] != 0) continue;
				changedZero++;
				arr[nr][nc] = 1;
				q.offer(new int[] { nr, nc, min_change_cnt });
			}
		}
		if (zeros != changedZero) min_change_cnt = -1;
		else min_change_cnt--;
		bw.write(String.valueOf(min_change_cnt));
		br.close();
		bw.flush();
		bw.close();
	}
}
