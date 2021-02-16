package SSAFY_Algorithm.Tree.BOJ_20364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class kangyj {
	static boolean[] visited; // 점유한 땅인지 체크하는 배열
	static Stack<Integer> div = new Stack<Integer>(); // 왼쪽 오른쪽 방향
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 땅의 개수
		int Q = Integer.parseInt(st.nextToken()); // 오리의 수
		visited = new boolean[N + 1]; // 배열 index 1부터 쓰기 위해

		for (int i = 0; i < Q; i++) {
			// 원하는 땅의 번호를 2 또는 3이 나올때 까지 2로 나눔.
			int idx = Integer.parseInt(br.readLine()); // 원하는 땅의 번호
			int tmp = idx;

			while (true) { // tmp가 2거나 3이면 멈춰라
				if (tmp == 2 || tmp == 3) {
					break;
				}
				div.push(tmp % 2); // 나머지 저장(0이면 왼쪽. 1이면 오른쪽)
				tmp /= 2; // 2로 나누기
			}
			dfs(idx, tmp);

		}

		System.out.println(sb.toString());
	}

	// idx: 내가 가고자 하는 최종 목표 땅, next: 다음에 탐색할 땅
	static void dfs(int idx, int next) {
		if (!visited[next]) { // 점유되지 않은 땅을 지나가는 경우
			if (idx == next) {// 가고자하는 idx와 next가 같을 경우, 원하는 땅에 도착했으므로 0 리턴
				visited[idx] = true; // 땅 점유했다고 표시
				sb.append(0 + "\n");
				div.clear();
				return;
			}

			// 원하는 땅이 아니면서 점유된 땅이 아닌 경우, 계속 탐색
			dfs(idx, next * 2 + div.pop());

		} else { // 이미 점유된 땅을 지나가는 경우
			sb.append(next + "\n");
			div.clear();
			return;
		}
	}
}
