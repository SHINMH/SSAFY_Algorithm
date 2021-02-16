package SSAFY_Algorithm.Tree.BOJ_15900;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class parksr {
	static LinkedList<Integer>[] list;
	static int total = 0;
	
	// index : 현재 내가 판단할 배열 인덱스
	// from : 이전에 이동해온 배열 인덱스. 이 값을 기억 안 하면 무한재귀에 갇혀버린다ㅠ
	// cnt : 리프노드까지의 깊이를 계산하는 변수
	public static void dfs(int index, int from, int cnt) {
		
		// 이거 for-each문으로 안 하니까 시간 초과 남; 하;
		for (int i :list[index]) {
			if (i != from) {
				dfs(i, index, cnt + 1);
			}
		}
		// 이 조건문이 밑에 있는 이유는 : 간선이 딱 하나 있으면 얘가 걍 0으로 출력돼버리기 때문... 일단 한 번 돌고 조건 체크해주기.
		if (list[index].size() == 1) {
			total += cnt;
			return;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/tree/tree_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		list = new LinkedList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		// 1번 인덱스부터 시작!
		dfs(1, 0, 0);
		System.out.println(total % 2 == 1 ? "Yes" : "No");
	}
}
