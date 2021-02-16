package SSAFY_Algorithm.Tree.BOJ_15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class kangyj {
	static LinkedList<Integer>[] list; // 트리 정보를 관리할 리스트
	static boolean[] visited; // 방문한 노드 기록하는 배열
	static int res = 0; // 결과 변수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 정점의 개수
		list = new LinkedList[N+1]; // 노드 번호 그대로 index로 쓰기 위해 사이즈 +1
		visited = new boolean[N+1]; // 노드 번호 그대로 index로 쓰기 위해 사이즈 +1
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 간선 연결해주는 작업
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1, visited, 0); // 배열에 1부터 넣었으니 시작은 1부터!
		
		if(res % 2 == 0) // 깊이가 짝수면 진다.
			System.out.println("No");
		else // 깊이가 홀수면 이긴다.
			System.out.println("Yes");	
	}
	
	// 깊이 탐색 함수
	static void dfs(int current, boolean[] visited, int depth) {
		visited[current] = true; // 방문 표시
		
		for (int next : list[current]) {
			if(!visited[next]) { // 방문한 적 없는 노드면 탐색
				dfs(next, visited, depth+1);
			}
		}
		
		// 리프 노드를 만났을 때 => 간선이 한개 (루트 노드여도 depth가 0이므로 상관 없음!)
		if(list[current].size() == 1) {
			res += depth;
		}
	}
}
