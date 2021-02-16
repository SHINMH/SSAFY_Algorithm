package SSAFY_Algorithm.Tree.BOJ_15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 1) 리프노드에 말 하나씩 놓임
// 2) 존재하는 말 중 아무거나 부모노드로 말을 움직임 - 한노드에 여러개 노드 ㅇㅋ 
// 3) 루트 노드 도착 시 즉시 말을 제거한다. 
// 4) 다음 사람 차례 턴 

// 성원 선 / 형석 후 

// 홀수인 간선이면 이김  
public class leemz {
	static List<Integer>[] list;
	static int n;
	static boolean[] isConnected;
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine()); // 트리의 정점 개수
		list = new List[n+1];
		
		isConnected = new boolean[n+1]; // 간선과 연결 정보 담는 배열
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		isConnected[1] = true;
		dfs(1, 0);
		
		if(cnt % 2 == 0) {
			System.out.println("No");
			return;
		}
			
		System.out.println("Yes");
		

	}
	
	public static void dfs(int current, int dep) {
		
		for (int i = 0; i < list[current].size(); i++) {
			int next = list[current].get(i);
			if(!isConnected[next]) {
				isConnected[next] = true;
				dfs(next, dep+1);
			}
		}
		
		if(list[current].size() == 1) { 
			cnt += dep;
		}
		
	}

}




































