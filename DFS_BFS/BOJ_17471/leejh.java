package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * [BOJ_17471] 게리멘더링
 * 1. 선거구을 2개로 나눈다.
 * 2. 나눠진 선거구가 붙어있는지 유효성 검사를 한다.
 * 3. 유효성 검사를 통과했다면 두 선거구의 인구 수 차를 계산한다.
 * 4. 인구 수 최소값 출력 
 * 
 */

public class leejh {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); // 구역 수
		HashMap<Integer, Integer> map = new HashMap<>(); // 구역 별 인구 수
		
		
		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) // 구역별 인구 수 입력 (key는 1부터 시작 not 0)
			map.put(i, Integer.parseInt(input[i - 1]));
		
		int[][] graph = new int[n + 1][]; // 구역 별 인접 구역 저장 배열
		for (int i = 1; i <= n; i++) { // 구역별 인접 구역 저장
			input = br.readLine().split(" ");
			graph[i] = new int[Integer.parseInt(input[0])];
			for (int j = 1; j <= graph[i].length; j++) 
				graph[i][j - 1] = Integer.parseInt(input[j]); 
		}
		
		int min = 10000; // 최솟값 저장
		int end = 1 << n - 1; // n개의 bit 중 마지막 경우의 수           	ex) if n==5 : end = 11111
		for (int i = 1; i < end; i++) { // 선거구 나누기			    i <= 00001 ~ 11110 까지의 조합을 갖는다 
			// 유효성 검사하기!										00000과 11111은 2개의 선거구로 나누어질 수 없기에 제외
			int size = Integer.bitCount(i);	// size는 groupA의 len이며 2진수로 변환한 i가 포함하고 있는 1의 개수가 size이다. 자동으로 0으로 set되어있는 자리는 groupB로 분류됨.
			int[] groupA = new int[size], groupB = new int[n - size];
			for (int idx = 0, a = 0, b = 0; idx < n; idx++) { // groupA와 groupB에 나눠진 선거구를 각각 저장
				if ((i & (1 << idx)) > 0) // 해당 자리가 1일 때 groupA에 저장
					groupA[a++] = idx + 1;
				else						// 해당 자리가 0일 때 groupA에 저장
					groupB[b++] = idx + 1;
			}
			if (!check(groupA, groupB, i, graph, n)) // 유효성 검사
				continue; // false 반환 시 다음 경우의 수로 continue

			// 인구 수 계산
			int res = 0; 
			for (int idx = 0; idx < groupA.length; idx++) // groupA의 인구수 더해줌
				res += map.get((Integer) groupA[idx]); 

			for (int idx = 0; idx < groupB.length; idx++) // groupB의 인구수 빼줌
				res -= map.get((Integer) groupB[idx]);

			min = Math.min(min, Math.abs(res)); // 인구수 차의 절댓값과 min을 비교
		}

		bw.write((min == 10000) ? "-1" : String.valueOf(min));
		bw.close();
	}

	private static boolean check(int[] groupA, int[] groupB, int group, int[][] graph, int n) { // BFS를 이용한 선거구 유효성 검사	  -  하나의 선거구가 서로 이어져있어야함.
		// 매개변수 group => 비트마스크로 표현된 현재 나눠진 선거구의 조합
		// ------------------------groupA---------------------------------
		int size = groupA.length;
		Queue<Integer> q = new LinkedList<>();
		q.offer(groupA[0]);
		int visited = 1 << (groupA[0] - 1);
		int curr;
		while (!q.isEmpty()) {
			curr = q.poll();
			for (int i = 0; i < graph[curr].length; i++) {
				if ((visited & (1 << (graph[curr][i] - 1))) == 0) { // 방문한적 없는 구역
					if ((group & (1 << (graph[curr][i] - 1))) > 0) { // groupA에 포함되어있는 구역
						q.offer(graph[curr][i]);
						visited |= (1 << (graph[curr][i] - 1));
					}
				}
			}
		}
		if (group != visited) // group에 groupA의 구역이 1로 set되어있고 visited도 groupA가 다 연결이 되어있다면
			return false;	  // groupA에 해당하는 구역이 1로 set되기 때문에 visited == group이어야한다 
							  // 다르면 유효성 검사 실패

		// ------------------------groupB---------------------------------
		// groupA의 유효성 검사와 동일
		visited = 1;
		size = n - size;
		q = new LinkedList<>();
		q.offer(groupB[0]);
		visited <<= (groupB[0] - 1);
		while (!q.isEmpty()) {
			curr = q.poll();
			for (int i = 0; i < graph[curr].length; i++) {
				if ((visited & (1 << (graph[curr][i] - 1))) == 0) { // 방문한적 없는 구역
					if ((group & (1 << (graph[curr][i] - 1))) == 0) { // groupB에 포함되어있는 구역  ( groupB는 group에서 0으로 세트되어있다 )
						q.offer(graph[curr][i]);
						visited |= (1 << (graph[curr][i] - 1));
					}
				}
			}
		}
		if (groupB.length != Integer.bitCount(visited)) // groupB의 길이와 visited에 1로 set있는 bit 수(방문한 구역의 길이)가 다르면 유효성 검사 실패 
			return false;
		else
			return true;
	}
}
