package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	static public class Tower {
		public int idx;
		public long h;

		public Tower(int idx, long h) {
			this.idx = idx;
			this.h = h;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Long temp = 0L;
		Stack<Tower> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			temp = Long.parseLong(st.nextToken());
			while(!stack.isEmpty()) { 
				if(stack.peek().h >= temp) { // stack의 top에 현재 탑 보다 큰 탑이 있다면 top의 index값 출력
					sb.append(stack.peek().idx).append(" ");
					break;
				}
				stack.pop(); // 현재 탑보다 작을 경우 stack에서 제거
			}
			if(stack.isEmpty()) sb.append("0 "); // 빈 stack이라면 왼쪽에 자신보다 큰 탑이 없기 때문에 0 출력
			stack.push(new Tower(i,temp)); // 현재 탑을 스택에 push하고 다음 탑으로 continue
		}
		System.out.println(sb);
	}

}
