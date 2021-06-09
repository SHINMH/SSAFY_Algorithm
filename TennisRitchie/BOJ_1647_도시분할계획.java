package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1647_도시분할계획 {
	private static int[] parent;
	private static class Edge implements Comparable<Edge> {
		private int from, to, weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight > o.weight ? 1 : -1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input= br.readLine().split(" ");
		int N =  Integer.parseInt(input[0]);
		int M =  Integer.parseInt(input[1]);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		parent = new int[N+1];
		for(int i = 0; i<=N;i++)parent[i]=i;
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			pq.offer(new Edge(from, to, weight));
		}
		int cost = 0,cnt=0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int a = find(edge.from);
			int b = find(edge.to);
			
			if(a==b) continue;
			union(a,b);
			cost+=edge.weight;
			cnt++;
			if(cnt==N-2) break;
		}
		System.out.println(cost);
	}
	private static int find(int a) {
		if(a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot!=bRoot) parent[aRoot]=b;
		else return;
	}
}
