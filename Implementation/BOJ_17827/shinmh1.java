package SSAFY_Algorithm.Implementation.BOJ_17827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class shinmh1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 노드 수
		int M = Integer.parseInt(st.nextToken()); // 질문 수
		int V = Integer.parseInt(st.nextToken()); // 마지막 번호가 가르키는 노드
		
		int[] list = new int[N + 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine()) + 1;
			if(num > V) {
				num = V + (num - V) % (N - V + 1);
			}
			sb.append(list[num] + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}