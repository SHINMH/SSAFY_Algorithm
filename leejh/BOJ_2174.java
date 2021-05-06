package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2174 {
	private static class Robot {
		int x,y,dir;
		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	private static class Command {
		int num,cnt;
		String type;
		public Command(int num, String type, int cnt) {
			this.num = num;
			this.type = type;
			this.cnt = cnt;
		}
	}

	private static int A, B, N, M;
	private static Robot[] robot;
	private static Command[] command;
	private static int[][] check;
	private static int[] dx = { -1, 0, 1, 0 }; // 북서남동
	private static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new int[A][B];

		robot = new Robot[N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			String s = st.nextToken();
			int dir = -1;
			if (s.equals("N")) // 북
				dir = 3;
			else if (s.equals("W")) // 서
				dir = 0;
			else if (s.equals("S")) // 남
				dir = 1;
			else if (s.equals("E")) // 동
				dir = 2;

			robot[i] = new Robot(x, y, dir);
			check[x][y] = i;
		}

		command = new Command[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			command[i] = new Command(num, type, cnt);
		}

		int[] ans = work();
		if (ans[0] == 1)
			System.out.println("Robot " + ans[1] + " crashes into the wall");
		else if (ans[0] == 2)
			System.out.println("Robot " + ans[1] + " crashes into robot " + ans[2]);
		else
			System.out.println("OK");
	}

	private static int[] work() {
		for (int i = 0; i < command.length; i++) {
			Command c = command[i];
			int[] result = check(c);

			if (result[0] > 0)
				return result;
		}
		return new int[] { 0, 0, 0 };
	}

	private static int[] check(Command c) {
		Robot r = robot[c.num];
		int[] result = new int[3]; // 결과, X,Y

		switch (c.type) {
		case "L":
			int turnL = c.cnt % 4;
			int dirL = r.dir;
			turnL += dirL;
			if (turnL >= 4)
				turnL %= 4;
			robot[c.num].dir = turnL;
			break;
		case "R":
			int turnR = c.cnt % 4;
			int dirR = r.dir;
			turnR = 4 - (turnR - dirR);
			turnR %= 4;
			robot[c.num].dir = turnR;
			break;
		case "F":
			int x = r.x;
			int y = r.y;
			for (int i = 1; i < c.cnt + 1; i++) {
				x += dx[r.dir];
				y += dy[r.dir];

				if (isRange(x, y)) {
					if (check[x][y] != 0) {
						result[0] = 2;
						result[1] = c.num;
						result[2] = check[x][y];
						return result;
					}
				} else {
					result[0] = 1;
					result[1] = c.num;
					return result;
				}
			}
			check[r.x][r.y] = 0;
			check[x][y] = c.num;
			robot[c.num].x = x;
			robot[c.num].y = y;
			break;
		}

		return result;
	}

	private static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < A && y < B;
	}
}