package Tree/BOJ_15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class kimmj {
	
	static int N;
	static LinkedList<Integer>[] tree;
	static int totalcnt;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N= Integer.parseInt(br.readLine());
		tree= new LinkedList[N+1];
		
		for (int i=0; i<=N; i++) {
			tree[i]= new LinkedList<>();
		}
		
		for (int i=0; i<N-1; i++) {
			
			st= new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());

			tree[x].add(y);
			tree[y].add(x);
			
		}

		totalcnt= 0;
		
		DFS(1, 0, 0);
		
		System.out.println(((totalcnt%2==0)? "No":"Yes"));
		
	}

	public static void DFS(int current, int cnt, int before) {

		for (int next: tree[current]) {
			if (next!=before) {
				DFS(next, cnt+1, current);
			}
		}
		
		if (tree[current].size()==1) {
			totalcnt+= cnt;
		}
	}

}
