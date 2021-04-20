package Implementation.BOJ_17827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class kimmj {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder answer= new StringBuilder();
		
		st= new StringTokenizer(br.readLine(), " ");
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		int V= Integer.parseInt(st.nextToken());
		
		int[] snail= new int[N];
		
		st= new StringTokenizer(br.readLine(), " ");
		for (int n=0; n<N; n++) {
			snail[n]=Integer.parseInt(st.nextToken());
		}
		
		for (int m=0; m<M; m++) {
			int K= Integer.parseInt(br.readLine());
			if (K<N)
				;
			else if (V==N) 
				K= N-1;
			else if (K>=N)
				K= (K-N) % (N-V+1) + (V-1);
			answer.append(snail[K] + "\n");
		}
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
}
