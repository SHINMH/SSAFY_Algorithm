package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int[] Durability = new int[2 * N];
		boolean[] robot = new boolean[2 * N];
		for (int i = 0; i < 2 * N; i++)
			Durability[i] = Integer.parseInt(input[i]);
		int cnt = 0, stage = 0, up = 0, down = N - 1;
		while (cnt < K) { // 단계 진행
			up = up == 0 ? 2 * N - 1 : up - 1; // 올리는 위치 set
			down = down == 0 ? 2 * N - 1 : down - 1; // 내리는 위치 set
			robot[down] = false; // 한 칸 돌린 후 로봇 내림
			if (up > down) { // up이 down 보다 클 경우
				for (int i = down; i > 0; i--) { 
					if (robot[i-1] && !robot[i] && Durability[i] > 0) { // 직전 칸에 로봇이 있고 현재 칸이 비어있고 내구도가 1이상일때
						robot[i - 1] = false;
						robot[i] = true;
						Durability[i]--;
						if (Durability[i] == 0) 
							cnt++;
					}
				}
				if (robot[2*N - 1] && !robot[0] && Durability[0] > 0) {
					robot[2*N - 1] = false;
					robot[0] = true;
					Durability[0]--;
					if (Durability[0] == 0)
						cnt++;
				}
				for (int i = 2 * N - 1; i > up; i--) {
					if (robot[i-1] && !robot[i] && Durability[i] > 0) {
						robot[i - 1] = false;
						robot[i] = true;
						Durability[i]--;
						if (Durability[i] == 0)
							cnt++;
					}
				}
			} else {
				for (int i = down; i > up; i--) {
					if (robot[i-1] && !robot[i] && Durability[i] > 0) {
						robot[i - 1] = false;
						robot[i] = true;
						Durability[i]--;
						if (Durability[i] == 0)
							cnt++;
					}
				}
			}
			if(Durability[up] > 0) { // 로봇 올림
				robot[up] = true;
				Durability[up]--;
				if (Durability[up] == 0)
					cnt++;
			}
			robot[down] = false;
			stage++;
		}
		System.out.println(stage);
	}
}
