package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] member = new int[N + 1];
			for (int i = 0; i < N; i++) { // 등수를 index로 지원 점수를 저장 
				st = new StringTokenizer(br.readLine());
				int resumeGrade = Integer.parseInt(st.nextToken());
				int interviewRank = Integer.parseInt(st.nextToken());
				member[interviewRank] = resumeGrade;
			}
			int ans = 1;
			int cutLine = 1; // 성적 cutline
			for (int i = 2; i <= N; i++) {
				if (member[cutLine] >= member[i]) { //cutline보다 성적이 높을 시 ans++ 후 cutliine 최신화
					ans++;
					cutLine = i;
				}
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}
}
