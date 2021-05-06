package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2346 {
	public static List<Integer> list = new LinkedList<>(); // 풍선 번호 저장 list
	public static List<Integer> listIndex = new LinkedList<>(); // 풍선 index 저장 list
	public static int N = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 풍선 개수

		st = new StringTokenizer(br.readLine());
		int i = 1; // 풍선 index
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken())); // 풍선 삽입
			listIndex.add(i++); // 풍선 index 삽입
		}

		int curr = 0; // 현재 풍선 위치
		int move = list.get(0); // 움직일 풍선 위치
		listIndex.remove(curr); // 첫번째 풍선 제거
		list.remove(curr); //첫번째 풍선 index 제거
		bw.write("1 "); // 첫번째 풍선 -> 1 출력 
		while (!list.isEmpty()) { // 풍선이 다 터질 때까지 반복
			if (move > 0) // 오른쪽으로 이동할 경우
				curr = (curr + move - 1) % list.size();
			else { // 왼쪽으로 이동할 경우
				curr = (curr + move) % list.size();
				if (curr < 0) // 이동한 index가 양수면 남아있는 풍선 개수에 이동할 index를 더해줘서 터뜨를 풍선의 위치를 구함 
					curr += list.size();
			}
			move = list.get(curr); //다음 이동할 거리
			list.remove(curr); //현재 풍선 터뜨림
			bw.write(listIndex.get(curr) + " "); // 터뜨린 풍선의 기존 index 출력 및 제거
			listIndex.remove(curr);
		}
		bw.close();
	}
}
