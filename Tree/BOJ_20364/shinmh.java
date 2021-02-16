package BOJ.problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class shinmh {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		boolean[] tree = new boolean[N+1];
		for(int i = 0; i < Q; i++) {
			int num = Integer.parseInt(br.readLine());
			int j = num;
			int min = Integer.MAX_VALUE;
			
			while(j > 0) {
				if(tree[j]) {
					min = j;
				}
				j /= 2;
			}
			if(j == 0) {
				tree[num] = true;
			}
			
			sb.append((min == Integer.MAX_VALUE ? 0 : min) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
