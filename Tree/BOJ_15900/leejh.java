package SSAFY_Algorithm.Tree.BOJ_15900;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class leejh {
	static int EdgeLen = 0; // 트리의 총 간선 개수
	static ArrayList<Integer>[] Graph; // 각 정점과 인접하고 있는 정점들을 저장하는 배열
	static boolean[] visited; // 방문 여부 판단 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Graph = new ArrayList[N + 1]; // 각 정점의 실제 값과 Graph배열의 index를 일치시켜주기위해 N+1개의 배열을 할당
		visited = new boolean[N + 1]; 
		
		for (int i = 1; i <= N; i++) // 각 정점에 ArrayList 생성
			Graph[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) { // 정점 입력
			st = new StringTokenizer(br.readLine());
			int V1 = Integer.parseInt(st.nextToken());
			int V2 = Integer.parseInt(st.nextToken());
			// 인접한 두 정점을 서로의 인접 리스트에 넣어줌
			Graph[V1].add(V2);
			Graph[V2].add(V1);
		}
		DFS(1, 0); // 깊이 우선 탐색 실행
		bw.write((EdgeLen % 2 == 0) ? "No" : "Yes");
		bw.flush();
	}

	static void DFS(int V, int level) {
		visited[V] = true; // 현재 정점을 방문했다고 check
		if (Graph[V].size() == 1) // leaf 노드이면 현재 레벨 값을 트리의 총 간선 개수에 더해줌
			EdgeLen += level;
		for (int temp : Graph[V]) // 현재 정점의 인접 정점 순회
			if (!visited[temp]) // 지금까지 방문하지 않은 노드라면 level+1을 해주고 해당 인접 정점으로 이동
				DFS(temp, level + 1);
	}
}
