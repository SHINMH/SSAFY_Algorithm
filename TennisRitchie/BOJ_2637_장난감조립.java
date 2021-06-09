package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2637_장난감조립 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String input[] = null;
		int[][] stuff = new int[N + 1][N]; // row번의 부품 or 완제품을 만드는데 필요한 부품들의 개수
		ArrayList<Integer> graph[] = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();
		int[] indegree = new int[N + 1]; // 각 정점에 들어오는 정점의 개수 저장 배열
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int n = Integer.parseInt(input[2]);
			stuff[x][y] = n; // x를 만드는데 필요한 y의 개수
			indegree[x]++; // x에 y가 들어왔으니 x로 들어오는 정점 개수를 +1 해줌
			graph[y].add(x); 
		}
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> TopologicalSort = new ArrayList<Integer>();
		ArrayList<Integer> baseItem = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			if (indegree[i] == 0) { // 기본부품이라면 queue와 기본 부품 list에 넣어줌
				baseItem.add(i);
				q.offer(i);
			}
		} // 기본 부품 q에 넣기
		while (!q.isEmpty()) { // 위상정렬 start!
			int curr = q.poll();
			if (!baseItem.contains((Integer)curr))
				TopologicalSort.add(curr); // 큐에서 빼낸 값이 중간 부품이거나 완제품일 때 위상정렬 결과 list에 add
			for (Integer in : graph[curr]) { // 현재 정점이 가리키는 정점들을 하나씩 빼준다가 들어온 정점이 0개가 되는 정점을 큐에 넣어준다.
				indegree[in]--;
				if (indegree[in] == 0) q.offer(in);
			}
		}
		for (Integer i : TopologicalSort) // 위상정렬된 순서대로 memoization 기법을 활용하여 총 필요한 부분부품의 개수를 구해준다
			for (int j = 1; j < N; j++)
				if (stuff[i][j] != 0 ) // j가 i의 부품일 때
					for (Integer k : baseItem) // j를 만드는데 필요한 기본 부품 개수에 i를 만드는데 필요한 j의 개수를 곱해주고 더해준다
						stuff[i][k] += stuff[j][k] * stuff[i][j]; 
		
		for (Integer i : baseItem) bw.write(i + " " + stuff[N][i] + "\n");
		bw.close();
	}
}