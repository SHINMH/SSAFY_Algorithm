package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[100][100];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int row = y; row < y + 10; row++)
				for (int col = x; col < x + 10; col++)
					map[row][col] = true;
		}
		int cnt = 0;
		for (int row = 0; row < 100; row++)
			for (int col = 0; col < 100; col++)
				if (map[row][col]) cnt++;
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}
