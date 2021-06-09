package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int N = (int) Math.pow(2, K) - 1;
		int[] InOrder = new int[N];
		
		for (int i = 0; i < N; i++)
			InOrder[i] = Integer.parseInt(st.nextToken());
		
		int[][] levelOrder = new int[K][];
		for (int i = 0; i < K; i++)
			levelOrder[i] = new int[(int) Math.pow(2, i)];
		
		levelOrder(levelOrder,InOrder,0,0,K);
		
		for (int i = 0; i < K; i++) {
			for(int j = 0; j < (int) Math.pow(2, i);j++) {
				bw.write(String.valueOf(levelOrder[i][j]+" "));
			}
			bw.write("\n");
		}
		bw.close();
	}

	private static void levelOrder(int[][] levelOrder, int[] InOrder, int start, int level, int K) {
		if (level == K)
			return;
		int N = (int) Math.pow(2, (K - level));
		int root = (start + N - 1) / 2;
		for (int i = 0; i < levelOrder[level].length; i++)
			if (levelOrder[level][i] == 0) {
				levelOrder[level][i] = InOrder[root];
				break;
			}
		if (level < K-1) {
			levelOrder(levelOrder,InOrder,start,level+1,K);
			levelOrder(levelOrder,InOrder,start+N,level+1,K);
		}
	}
}
