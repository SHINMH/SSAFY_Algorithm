package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068 {
	private static int ans = 0;
	private static boolean f = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] tree = new ArrayList[N]; // tree 저장
		for (int i = 0; i < N; i++)
			tree[i] = new ArrayList<>();

		int root = 0; 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if (node == -1)
				root = i; //root 노드 저장
			else
				tree[node].add(i); // tree에 추가
		}

		int r = Integer.parseInt(br.readLine());
		if (root == r) // 제거 대상과 root가 같으면 0 출력
			bw.write(String.valueOf(ans));
		else {
			remove(tree, root, r); // 제거 대상 제거
			dfs(tree, root, r); // 리프노드 개수 계산
			bw.write(String.valueOf(ans));
		}
		bw.close();
	}

	private static void remove(ArrayList<Integer>[] tree, int curr, int r) { // 제거 대상 제거
		for (int i = tree[curr].size()-1; i >=0; i--) { // 제거 대상 검색 후 제거
			if (tree[curr].get(i) == r) {
				tree[curr].remove(i);
				f = true;
				return;
			} else
				remove(tree, tree[curr].get(i), r);
			if (f)
				return;
		}
	}

	private static void dfs(ArrayList<Integer>[] tree, int curr, int r) { 
		if (tree[curr].size() == 0) { // 리프 노드 이면 ans + 1
			ans++;
			return;
		}
		for (int i = 0; i < tree[curr].size(); i++)
			dfs(tree, tree[curr].get(i), r);
	}
}
