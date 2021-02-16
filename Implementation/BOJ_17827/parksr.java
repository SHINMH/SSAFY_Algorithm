package SSAFY_Algorithm.Implementation.BOJ_17827;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class parksr {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/linkedlist/snail_test.txt"));
		long start = System.currentTimeMillis();
		// --------------------------------------------------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodeNum = Integer.parseInt(st.nextToken());
		int question = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		v = v - 1; // 나는 인덱스가 0~N-1이라서 하나 빼줬음.

		int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// --------------------------------------------------------------------------
		for (int i = 0; i < question; i++) {
			int move = Integer.parseInt(br.readLine());
			int diff = nodeNum - v;

			// 이어진 노드까지만 가는 경우 : 그냥 간다.
			// move횟수는 인덱스 번호 -1까지니까, move < v+1 => v까지만 가는거라면~!
			if (move < v + 1) {
				sb.append(data[move]).append("\n");
				continue;
			}
			// v : 앞에 이어지지않은 만큼은 이동
			// 총 이동수 - v % 싸이클 주기
			sb.append(data[v + (move - v) % diff]).append("\n");

		}
		System.out.println(sb);
		long end = System.currentTimeMillis();
		System.out.println("---------------\n실행 시간 : " + (end - start) / 1000.0);
	}
}
