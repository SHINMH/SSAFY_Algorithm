package DFS_BFS.BOJ_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 도착 칸 : 사다리 -> 위로이동 ( 원래 있던 칸 번호보다 커짐 )
// 도착 칸 : 뱀 -> 아래 이동 ( 원래 있던 칸 번호보다 작아짐 )
// 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값
// BFS

public class leemz {
	static int N, M;
	static int[] arr = new int[101]; // 뱀, 사다리 배열
	static int[] diceCnt = new int[101]; // 주사위 움직일 때 cnt 배열
	static boolean[] isVisited = new boolean[101]; // 중복체크 배열 
	static int min; // 주사위를 굴려야 하는 횟수의 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 입력 값에 따른 위치 값 셋팅
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[p] = v;
		}

		bfs(); 

		System.out.println(min); // 결과
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>(); // 큐를 만들어 bfs 탐색
		
		// 1번은 무조건 들어가니까 중복체크, 큐에 add
		isVisited[1] = true; 
		q.add(1);

		// 큐가 빌때까지 탐색 - bfs 시작 
		while (!q.isEmpty()) {
			int now = q.remove(); // 현재 위치 값 
			int cnt = diceCnt[now]; // 주사위 굴린 횟수

			if (now == 100) { // 현재 위치가 100이 되면 min에 현재 카운트된 숫자 cnt 넣어줌
				min = cnt;
				break;
			}

			int dice = 0; // 주사위 
			
			for (int i = 1; i <= 6; i++) { // 주사위 눈 1 ~ 6 까지
				dice = now + i; // 주사위에 현재 위치와 주사위 굴려서 나온 눈 더해줌

				if (dice > 100 || isVisited[dice] == true) // 100이 넘거나 이미 방문했다면 넘어가 ~ 
					continue;

				isVisited[dice] = true; // 방문 안한 위치 true 

				if (arr[dice] == 0) { // 뱀이나 사다리가 없다면 
					diceCnt[dice] = cnt + 1;
					q.add(dice);
				} else { // 뱀이나 사다리 있을 때
					dice = arr[dice];
					if (!isVisited[dice]) {
						isVisited[dice] = true;
						diceCnt[dice] = cnt + 1;
						q.add(dice);
					}
				}

			}
		}

	}

}
