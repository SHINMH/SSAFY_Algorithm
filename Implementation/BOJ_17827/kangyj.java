package SSAFY_Algorithm.Implementation.BOJ_17827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class kangyj {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 노드의 갯수
		int M = Integer.parseInt(st.nextToken()); // 질문의 횟수
		int v = Integer.parseInt(st.nextToken()); // 마지막 노드가 가르키는 노드 번호
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) { // 배열 초기화 작업
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(br.readLine());

			if (idx < N) { // 싸이클 부분을 넘어가지 않는 index
				sb.append(arr[idx] + "\n");
			} else { // 싸이클 부분을 포함하는 index의 경우
				int repeat = N - v + 1; // 반복되는 부분 길이
				idx = idx - (v - 1); // 반복되지 않는 길이 제외 
				// 반복되는 부분은 나머지 연산을 통해 index를 구하고, 반복되지 않는 길이만큼 다시 더해줌.
				sb.append(arr[(idx % repeat) + v - 1] + "\n"); 
			}
		}
		System.out.println(sb.toString());
	}
}
