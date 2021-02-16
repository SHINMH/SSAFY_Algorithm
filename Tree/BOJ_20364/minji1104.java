package codingStudty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 왜 틀렸는지 모르겠음 
public class BJ_20364 {

	public static void main(String[] args) throws IOException {
		// 오리들 한 줄로 대기 후 1번부터 번호대로 땅 가짐
		// 이미 점유 중이라면 Pass.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<Integer>(); // 오리들이 원하는 값 넣어줄 것임 

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 땅 개수
		int q = Integer.parseInt(st.nextToken()); // 오리 수

		int[] tree = new int[n + 1];

		tree[1] = 1;

		// 나머지 트리 셋팅 - 입력된 땅의 개수대로 
		for (int i = 1; i <= n; i++) {
			if (i * 2 <= n) {
				tree[i * 2] = i * 2;
			}

			if (i * 2 + 1 <= n) {
				tree[i * 2 + 1] = i * 2 + 1;
			}

		}

		// 오리들 원하는 땅 큐에 저장
		for (int i = 0; i < q; i++) {
			int want = Integer.parseInt(br.readLine());
			queue.offer(want);
		}

		// 위에 노드까지 봐줘야함 - 고치기  
		for (int i = 1; i <= q; i++) {
			int chk = queue.poll();
			if (tree[chk] != 0 && tree[chk / 2] != 0) {
				tree[chk] = 0;

				System.out.println("0");
			} else {
				System.out.println(chk / 2);
			}
		}

	}

}
