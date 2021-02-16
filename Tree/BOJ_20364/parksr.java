package SSAFY_Algorithm.Tree.BOJ_20364;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class parksr {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/tree/ducks_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		// N : 땅의 개수
		// Q : 오리 수
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] visited = new int[N + 1];

		for (int i = 0; i < Q; i++) {

			int n = Integer.parseInt(br.readLine());
			int ducks = n;
			int stop = 0;

			while (n > 0) {
				// 루트까지 거슬러 올라가면서, 더 위에서 막힐 때마다 stop을 갱신해준다.
				if (visited[n] != 0) {
					stop = n;
				}
				n /= 2;
			}

			// 해당하는 땅 까지 갈 수 있다면 0을 출력, 방문리스트에 이 땅(ducks)을 넣는다.
			if (stop == 0) {
				visited[ducks] = 1;
			}
			sb.append(stop).append("\n");

		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
