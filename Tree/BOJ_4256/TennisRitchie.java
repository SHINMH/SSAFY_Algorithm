package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4256_트리 {
	static int T, n; // 테스트 케이스
	static int[] inOrder, preOrder; // 중위,전위 순회 값 저장
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			n = Integer.parseInt(br.readLine()); // 노드 개수
			inOrder = new int[n]; 
			preOrder = new int[n];

			st = new StringTokenizer(br.readLine()); // 전위 순회 저장
			for (int i = 0; i < n; i++) preOrder[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()); // 중위 순회 저장
			for (int i = 0; i < n; i++) inOrder[i] = Integer.parseInt(st.nextToken());
			postOrder(0, n, 0, n); // 후위순회 실시
			bw.write("\n");
		}
		bw.close();
	}

	static void postOrder(int preBegin, int preEnd, int inBegin, int inEnd) throws IOException {
		int i = inBegin;
		for (; i < inEnd; i++) { // sub tree의 중위 순회에서 root node인 preOrder[preBegin]의 값의 index를 찾음
			if (inOrder[i] == preOrder[preBegin]) break;
		}
		int dist = i-inBegin; // root 노드 기준 왼쪽 sub tree가 포함하고 있는 노드 개수
		if (inBegin < i) postOrder(preBegin + 1, preBegin + dist, inBegin, i); // root 노드 기준 왼쪽에 sub tree가 존재하다면 왼쪽 sub tree로 이동
		if (i + 1 < inEnd) postOrder(preBegin + dist+1, preEnd, i+1, inEnd); // root 노드 기준 오른쪽에 sub tree가 존재하다면 오른쪽 sub tree로 이동
		bw.write(preOrder[preBegin] + " "); // root 노드 출력
	}
}
