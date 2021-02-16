package SSAFY_Algorithm.LinkedList.BOJ_1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BJ_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Character> list = new LinkedList<>();
		
		String s = br.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		int M = Integer.parseInt(br.readLine()); // 명령어 수
		ListIterator<Character> iter = list.listIterator(); // 커서
		while(iter.hasNext()) // 커서 문장의 끝으로 이동
			iter.next();	

		/* 명령어 수만큼 반복 */
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char command = st.nextToken().charAt(0);

			if (command == 'L') { // 커서 왼쪽으로 한 칸 이동
				if (iter.hasPrevious())
					iter.previous();
			} else if (command == 'D') { // 커서 오른쪽으로 한 칸 이동
				if (iter.hasNext())
					iter.next();
			} else if (command == 'B') { // 커서 왼쪽에 있는 문자 삭제
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else if (command == 'P') { // 커서 왼쪽에 문자 추가
				iter.add(st.nextToken().charAt(0));
			}
		}

		/* 결과 출력 */
		for(char c : list) {
			bw.write(c);
		}
		
		bw.close();
	}
}
