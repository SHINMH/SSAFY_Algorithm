package leejh;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class BOJ_3190 {
	static class Pos {
		int x, y;
		public Pos(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		String input[];
		Pos[] Apples = new Pos[K];
		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			Apples[i] = new Pos(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
		}
		int L = Integer.parseInt(br.readLine());
		int[][] dirs = new int[L][2];
		for (int i = 0; i < L; i++) {
			input = br.readLine().split(" ");
			dirs[i] = new int[] { Integer.parseInt(input[0]), input[1].charAt(0) == 'L' ? 0 : 1 };
		}
		int time = 0;
		int dir = 0; // 0 : R 1 : D 2 : L 3 : U
		int cmd = 0;
		Pos curr = new Pos(0, 0);
		Queue<Pos> q = new LinkedList<>();
		while (true) {
			q.offer(new Pos(curr.y, curr.x));
			switch (dir) {
			case 0: // 오른쪽
				curr.x++; break;
			case 1: // 아래
				curr.y++; break;
			case 2: // 왼쪽
				curr.x--; break;
			case 3: // 위
				curr.y--; break;
			}
			time++;
			if (curr.x >= N || curr.y >= N || curr.x < 0 || curr.y < 0)
				break;
			Iterator<Pos> iter = q.iterator();
			boolean flag = false;
			while (iter.hasNext()) {
				Pos temp = iter.next();
				if (temp.x == curr.x && temp.y == curr.y) {
					flag = true;
					break;
				}
			}
			if (flag) break;
			flag = false;
			for (int i = 0; i < K; i++) {
				if (Apples[i].x == curr.x && Apples[i].y == curr.y) {
					Apples[i] = new Pos(-1, -1);
					flag = true;
					break;
				}
			}
			if (!flag) q.poll();
			if (cmd >= L) continue;
			if (dirs[cmd][0] == time) {
				if (dirs[cmd][1] == 0) dir = dir == 0 ? 3 : dir - 1;
				else dir = dir == 3 ? 0 : dir + 1;
				cmd++;
			}
		}
		System.out.println(time);
	}
}

