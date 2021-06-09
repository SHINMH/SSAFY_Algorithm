package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281 {
	static int N, input[][], arr[], ans;
	static int visited;

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new int[N][9];
		arr = new int[9];
		visited = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(ans);
	}

	static public void dfs(int idx) {
		if (idx == 9) {
			arr[3] = 0;
			play();
			return;
		}
		for (int i = 1; i < 9; i++) {
			if ((visited & (1 << i)) > 0)
				continue;
			if (idx == 3)
				idx++;
			visited |= (1 << i);
			arr[idx] = i;
			dfs(idx + 1);
			visited -= (1 << i);
		}
	}

	static public void play() {
		int index = 0,outCnt,score = 0,hit = 0;
		int base[] = new int[3];
		for (int turn = 0; turn < N; turn++) {
			outCnt = 0;
			base[0] = 0;
			base[1] = 0;
			base[2] = 0;
			while (outCnt < 3) {
				if (index == 9) index = 0;
				hit = input[turn][arr[index]];
				if (hit == 0) {
					outCnt++;
				} else if (hit == 1) {
					score += base[2];
					base[2] = base[1];
					base[1] = base[0];
					base[0] = 1;
				} else if (hit == 2) {
					score += base[2] + base[1];
					base[2] = base[0];
					base[1] = 1;
					base[0] = 0;
				} else if (hit == 3) {
					score += base[2] + base[1] + base[0];
					base[2] = 1;
					base[1] = 0;
					base[0] = 0;
				} else if (hit == 4) {
					score += base[2] + base[1] + base[0] + 1;
					base[2] = 0;
					base[1] = 0;
					base[0] = 0;
				}
				index += 1;
			}
		}
		ans = Math.max(ans, score);
	}
}