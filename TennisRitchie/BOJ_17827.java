package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17827{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드의 개수
		int M = Integer.parseInt(st.nextToken()); // 질문의 횟수
		int V = Integer.parseInt(st.nextToken()); // N번 노드가 가리키는 노드

		int[] C = new int[N]; // N개의 정수 C1~CN 담는 배열 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) //N개의 정수 C1~CN 입력 
			C[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(br.readLine()); // 질문 입력
			if (temp < V - 1) // 사이클 이전의 값을 요구하면 바로 출력
				bw.write(C[temp] + "\n");
			else // 사이클 내부의 값을 요구하면 논리적으로 사이클만 따로 떼어내서 나머지 연산을 통해 해당 자리 수 출력
				bw.write(C[(temp - (V - 1)) % (N - (V - 1)) + (V - 1)] + "\n");
		}
		bw.flush();
	}
}