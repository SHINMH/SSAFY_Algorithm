package SSAFY_Algorithm.Implementation.BOJ_17827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class shinmh2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 노드 수
		int M = Integer.parseInt(st.nextToken()); // 질문 수
		int V = Integer.parseInt(st.nextToken()); // 마지막 번호가 가르키는 노드
		
		int[][] list = new int[2][N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			list[0][i] = Integer.parseInt(st.nextToken());
			list[1][i] = i + 1;
		}
		list[1][N - 1] = V - 1;
		
		for(int i = 0; i < M; i++) {
			int count = Integer.parseInt(br.readLine());
			int position = 0;
			while(count > 0) {
				position = list[1][position];
				count--;
			}
			System.out.println(list[0][position]);
		}
	}
}
