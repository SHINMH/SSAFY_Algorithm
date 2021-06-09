package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20364 {
	static boolean[] visited; // 땅이 점유 됐는지 여부 check
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 땅 개수
		int Q = Integer.parseInt(st.nextToken()); // 오리 수
		visited = new boolean[N + 1]; // 완전 이진 트리의 각 노드의 점유 여부 저장 0 index는 사용 x
		for (int i = 0; i < Q; i++) {
			int AreaNum = Integer.parseInt(br.readLine());
			bw.write(Check(AreaNum) + "\n");
			visited[AreaNum] = true; // 현재 땅이 점유되었다고 check
		}
		bw.flush();
	}
	static int Check(int AreaNum) {
		int firstMeetArea = 0; // 가장 먼저 만난 점유되어있는 땅 -> 해당 땅이 점유 가능하면 그대로 0출력
		while (AreaNum > 0) {  //   					   해당 땅으로 가는 길에 점유되어있는 땅이 존재하면 가장 먼저 만난 점유되어있는 땅 출력
			if (visited[AreaNum]) // 점유된 땅이면
				firstMeetArea = AreaNum; // 현재 순회하고 있는 땅을 firstMeetArea에 넣어줌
			AreaNum = AreaNum / 2; // 부모 노드로 이동
		}
		return firstMeetArea; // 결과 출력
	}
}
