package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_5052_전화번호목록 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<String> pq = new PriorityQueue<>();
			for(int i = 0; i < N;i++) pq.offer(br.readLine()); // pq에 전화번호 삽입
			String prefix = pq.poll(); // 최솟값 prefix에 우선 넣어줌
			boolean flag = true; // 같은 prefix를 갖고있는 전화번호 탑색 여부 
			while(!pq.isEmpty()){
				String PN = pq.poll(); // 비교할 전번
				if(prefix.length()<PN.length()) { // prefix가 PN보다 길이가 작고
					if(PN.startsWith(prefix)) { // PN이 prefix로 시작한다면
						bw.write("NO\n"); // no 출력 후 다음 테케로 넘어감
						flag = false;
						break;
					}
				}
				prefix = PN; // prefix를 PN으로 update
			}
			if(flag) bw.write("YES\n"); // while문 무사 통과 시 yes 출력
		}
		bw.close();
	}
}
