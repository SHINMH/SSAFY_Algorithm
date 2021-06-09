package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1916 {
	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] input;
		List<Edge>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			graph[from].add(new Edge(to, weight));
		}
		input = br.readLine().split(" ");
		int start = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);

		int[] dijk = new int[N + 1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		dijk[start] = 0;
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visited[edge.v])
				continue;
			visited[edge.v] = true;
			for (Edge nextEdge : graph[edge.v]) {
				int currWeight = dijk[edge.v];
				if (!visited[nextEdge.v] && dijk[nextEdge.v] > currWeight + nextEdge.weight) {
					dijk[nextEdge.v] = currWeight + nextEdge.weight;
					pq.add(new Edge(nextEdge.v, dijk[nextEdge.v]));
				}
			}
		}
		System.out.println(dijk[end]);
	}
}
