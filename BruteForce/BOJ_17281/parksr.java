package permu_combi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.BitSet;

public class parksr {
	static int[][] score;
	static int Max = Integer.MIN_VALUE;
	
	/*
	 * 순열로 풀이.
	 * 각 9명의 인덱스로 순열을 만든 후에,
	 * 다 만들어지면 점수를 계산하는 함수를 돌림.
	 * 함수 설명은 길어져서 함수에 주석 작성. 
	 * */

	private static void permutation(int toSelect, int[] selected, boolean[] visited) {
		if (toSelect == 9) {
			calculateScore(selected);
			return;
		}
		if (toSelect == 3) {
			visited[0] = true;
			selected[toSelect] = 0;
			permutation(toSelect + 1, selected, visited);
		} else {
			for (int i = 1; i < 9; i++) {
				if (!visited[i]) {
					visited[i] = true;
					selected[toSelect] = i;
					permutation(toSelect + 1, selected, visited);
					visited[i] = false;
				}
			}
		}
	}
	
	private static void calculateScore(int[] selected) {
		int index = 0;	// 타순
		int rs = 0;		// 전체점수
		int whole_cnt = 0;	// 점수
		
		for (int i = 0; i < score.length; i++) {
			long sum = 1;
			int out = 0;
			while (out != 3) {
				
				// 아웃!
				if (score[i][selected[index]] == 0) {
					/*
					 * 아웃인 경우, 전체 숫자에서 1의 개수를 센 다음 -> wholecnt
					 * 맨 뒤 네자리만 살려놓고 -> 아직 점수가 안나고 그라운드에 있는 선수들
					 * 맨 뒤 네자리의 1의 개수를 아까 구한 wholecnt에서 빼준다.
					 * 그리고 점수에 더해줌 -> rs+=wholecnt
					 * */
					out++;
					whole_cnt = Long.bitCount(sum);
					sum &= 15;
					whole_cnt -= Long.bitCount(sum);
					rs += whole_cnt;
					/*
					 * 네자리만 살리는 이유: int와 long의 값 범위의 한계로 그냥 자름.
					 * */

				} 
				// 아웃 아님
				else {
					/*
					 * 해당 점수만큼 shift연산으로 왼쪽으로 밀어준 후에,
					 * 해당 점수 위치에 1을 넣는다
					 *     		3루 2루 1루 홈
					 * ex)   	 1   0   1  0 인 상황에서 2루타가 들어옴 -> 먼저 2 shift
					 *-> 1   0 	 1   0   0  0  							-> 이제 2루에 1을 넣음
					 *-> 1	 0   1   1   0  0
					 *-> 3루보다 앞에 있는 수들은 모두 '점수'가 됨.
					 * */
					sum = sum << score[i][selected[index]];
					sum |= (1 << score[i][selected[index]]);
				}
				
				// 다음 타순으로 넘어감
				index = (index + 1) % 9;
				
				// out이 3회면 break;
				if (out == 3) {
					break;
				}
			}
		}
		Max = Math.max(Max, rs);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/permu_combi/baseball_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int inning = Integer.parseInt(br.readLine());
		score = new int[inning][9];
		for (int i = 0; i < inning; i++) {
			score[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		permutation(0, new int[9], new boolean[9]);
		bw.write(String.valueOf(Max));
		br.close();
		bw.flush();
		bw.close();
	}
}
