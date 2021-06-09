package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static ArrayList<Integer>[] Graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int V = 0, E = 0, StartV = 0;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		StartV = Integer.parseInt(st.nextToken());
		Graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) Graph[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int V1 = Integer.parseInt(st.nextToken());
			int V2 = Integer.parseInt(st.nextToken());
			Graph[V1].add(V2);
			Graph[V2].add(V1);
		}
		for (int i = 1; i <= V; i++) Collections.sort(Graph[i]);
		DFS(StartV,new boolean[V+1]);
		System.out.println();
		BFS(StartV,new boolean[V+1]);
	}

	static void DFS(int V,boolean[] visited) {
		System.out.print(V + " ");
		visited[V] = true;
		for(int i = 0; i < Graph[V].size(); i++) {
			if(!visited[Graph[V].get(i)]) {
				DFS(Graph[V].get(i),visited);
			}
		}
	}

	static void BFS(int V,boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		visited[V] = true;
		while(!queue.isEmpty()) {
			V = queue.poll();
			System.out.print(V + " ");
			for(int i = 0; i < Graph[V].size(); i++) {
				if(!visited[Graph[V].get(i)]) {
					queue.offer(Graph[V].get(i));
					visited[Graph[V].get(i)] = true;
				}
			}
		}
	}
}
