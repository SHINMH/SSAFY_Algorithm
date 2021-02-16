package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
	static int N, M, cnt;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 }; // 해당 좌표 기준 상하좌우 이동 값 
	static int[][] map; // 치즈 정보 저장
	static int day = 0; // 소요 일 수 저장
	static LinkedList<int[]> removeList; // 해당 day에 상한 치즈 저장 후 일괄 제거

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //row 값
		M = Integer.parseInt(st.nextToken()); //col 값 
		map = new int[N][M];
		for (int row = 0; row < N; row++) { // map input
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++)
				map[row][col] = Integer.parseInt(st.nextToken());
		}
		boolean Flag; // map에 치즈가 남아있는지 확인 Flag
		dfs(0,0); // 맨 가장가리는 치즈가 올 수 없으므로 (0,0)에서 외부공기 영역 표시
		while (true){
			removeList = new LinkedList<>(); // day마다 removeList 초기화
			Flag = false; // Flag : false-> 남은 치즈가 없음 , true -> 치즈가 존재함
			for (int row = 1; row < N-1; row++) { // 가장자리를 제외한 영역 탐색 시작
				for (int col = 1; col < M-1; col++) {
					if (map[row][col] == 1) { // 치즈 탐색 성공
						Flag = true; // map에 치즈가 있다고 Flag true로 set해줌
						cnt = 0; // 해당 치즈가 외부공기와 접해있는 면의 개수 count
						for (int i = 0; i < 4; i++) { // 해당 치즈의 상하좌우에 외부공기가 있는지 탐색 후 cnt에 개수를 저장함
							int nextX = col + dx[i], nextY = row + dy[i];
							if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) 
								if (map[nextY][nextX] == -1)
									cnt++;
						}
						if (cnt > 1) removeList.offer(new int[] { row, col }); // cnt가 2이상일 경우 당일 상할 치즈이므로 removeList에 넣어줌 
					}
				}
			}
			if(!Flag) break; // map에 치즈가 더 이상 남아있지 않다면 while문 탈출
			Iterator<int[]> iter = removeList.iterator();
			while (iter.hasNext()) { // 탐색이 끝난 후 상한 치즈 제거
				int[] pos = iter.next();
				dfs(pos[0],pos[1]); // 상한 치즈 자리는 빈공간으로 대체되기 때문에 이 지점에서 다시 외부공기 영역을 재 탐색해줌
			}
			day++; // 하루가 지났음
		} 
		bw.write(String.valueOf(day));
		bw.close();
	}
	static void dfs(int row,int col) { //외부공기 인식
		map[row][col] = -1; // 해당 지점을 -1이라고 외부공기 표시를 해줌
		for (int i = 0; i < 4; i++) {
			int nextX = col + dx[i], nextY = row + dy[i];
			if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
				if (map[nextY][nextX] == 0) // 외부공기와 접해있는 내부 공기는 외부공기로 전환해줌
					dfs(nextY,nextX);
			}
		}
	}
}
