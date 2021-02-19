package SSAFY_Algorithm.Trre.BOJ_4256;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class shinmh {
	static int[] postOrder;
	static int[] inOrder;
	static int root;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while(TC > 0) {
			int N = Integer.parseInt(br.readLine());
			postOrder = new int[N];
			inOrder = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				postOrder[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				inOrder[i] = Integer.parseInt(st.nextToken());
			}
			
			root = 0;
			search(0, N-1);
			sb.append("\n");
			TC--;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void search(int start, int end) {
		int i;
		for(i = start; i <= end; i++) {
			if(postOrder[root] == inOrder[i]) {
				root++;
				search(start, i - 1);
				search(i + 1, end);
				sb.append(inOrder[i]).append(" ");
				break;
			}
		}
	}
}
