package SSAFY_Algorithm.Tree.BOJ_15900;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class shinmh {
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList[] list = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		count = 0;
		
		String[] str;
		int num, num2;
		for(int i = 0; i < N - 1; i++) {
			str = br.readLine().split(" ");
			num = Integer.parseInt(str[0]);
			num2 = Integer.parseInt(str[1]);
			
			list[num].add(num2);
			list[num2].add(num);
		}
	
		dfs(list, visited, 1, 0);

		bw.write(count % 2 == 1 ? "Yes" : "No");
		bw.close();
		br.close();
	}
	
	static void dfs(ArrayList[] list, boolean[] visited, int node, int depth) {
		if(node != 1 && list[node].size() == 1) {
			count += depth;
		}
		
		visited[node] = true;
		int num;
		while(!list[node].isEmpty()) {
			num = (int) list[node].remove(0);
			if(!visited[num]) {
				dfs(list, visited, num, depth + 1);
			}
		}
	}
}