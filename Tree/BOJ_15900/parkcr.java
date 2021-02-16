package SSAFY_Algorithm.Tree.BOJ_15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class parkcr {
	static ArrayList<ArrayList<Integer>> tree= new ArrayList<>();
	static int cnt;
	static int N;
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N+1;i++) {
			tree.add(new ArrayList<>());
		}
		
		int[] tmp = new int[2];
		for(int i=1; i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int t=0;t<2;t++) {
				tmp[t]=Integer.parseInt(input[t]);
			}
			tree.get(tmp[0]).add(tmp[1]); //양방향 인접리스트
			tree.get(tmp[1]).add(tmp[0]);
		}
		
		dfs(1,0,0); //루트노드 1부터 탐색
		System.out.println((result % 2) == 0 ? "No" : "Yes");
	
	}
	
	private static void dfs(int cur, int prev , int cnt) {
		for(int i=0; i<tree.get(cur).size();i++) {
			int next = tree.get(cur).get(i);
				if(next!=prev) {
					dfs(next,cur,cnt+1);
				}
		}
		//리프노드(노드의 사이즈가 1)일 때, 깊이 더해주기
		if(tree.get(cur).size()==1) {
			result += cnt;
		}
		
	}
}
