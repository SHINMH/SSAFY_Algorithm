package Greedy.BOJ_1783;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class kimmj {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		int answer= 1;
		
		if (N>=3 && M>=7) {
			M-=6;
			answer+=4;
			answer += M-1;
		} else if (N>=3 && M>=2) {
			answer += M-1;
			if (answer>4)
				answer= 4;
		} else if (N>=2 && M>=3) {
			answer+= (M-1)/2;
			if (answer>4)
				answer= 4;
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}
	
}
