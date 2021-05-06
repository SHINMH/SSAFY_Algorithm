package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16935 {
	public static int N = 0, M = 0, R = 0;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				arr = F1();
				break;
			case 2:
				arr = F2();
				break;
			case 3:
				arr = F3();
				break;
			case 4:
				arr = F4();
				break;
			case 5:
				arr = F5();
				break;
			case 6:
				arr = F6();
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				bw.write(arr[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
	}

	public static int[][] F1() {
		int[][] new_arr = new int[N][M];
		for (int i = N - 1; i >= 0; i--)
			for (int j = 0; j < M; j++)
				new_arr[N - i - 1][j] = arr[i][j];
		return new_arr;
	}

	public static int[][] F2() {
		int[][] new_arr = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = M - 1; j >= 0; j--)
				new_arr[i][M - j - 1] = arr[i][j];
		return new_arr;
	}

	public static int[][] F3() {
		int temp = N;
		N = M;
		M = temp;
		int[][] new_arr = new int[N][M];
		for (int row = 0; row < N; row++)
			for (int col = 0; col < M; col++)
				new_arr[row][col] = arr[M - 1 - col][row];
		return new_arr;
	}

	public static int[][] F4() {
		int temp = N;
		N = M;
		M = temp;
		int[][] new_arr = new int[N][M];
		for (int row = 0; row < N; row++)
			for (int col = 0; col < M; col++)
				new_arr[row][col] = arr[col][N - 1 - row];
		return new_arr;
	}

	public static int[][] F5() {
		int[][] new_arr = new int[N][M];
		int midN = N / 2, midM = M / 2;
		for (int row = 0; row < midN; row++)
			for (int col = 0; col < midM; col++)
				new_arr[row][col + midM] = arr[row][col];
		for (int row = 0; row < midN; row++)
			for (int col = midM; col < M; col++)
				new_arr[row + midN][col] = arr[row][col];
		for (int row = midN; row < N; row++)
			for (int col = midM; col < M; col++)
				new_arr[row][col - midM] = arr[row][col];
		for (int row = midN; row < N; row++)
			for (int col = 0; col < midM; col++)
				new_arr[row - midN][col] = arr[row][col];

		return new_arr;
	}

	public static int[][] F6() {
		int[][] new_arr = new int[N][M];
		int midN = N / 2, midM = M / 2;
		for (int row = 0; row < midN; row++)
			for (int col = 0; col < midM; col++)
				new_arr[row + midN][col] = arr[row][col];
		for (int row = 0; row < midN; row++)
			for (int col = midM; col < M; col++)
				new_arr[row][col - midM] = arr[row][col];
		for (int row = midN; row < N; row++)
			for (int col = midM; col < M; col++)
				new_arr[row - midN][col] = arr[row][col];
		for (int row = midN; row < N; row++)
			for (int col = 0; col < midM; col++)
				new_arr[row][col + midM] = arr[row][col];

		return new_arr;
	}
}
