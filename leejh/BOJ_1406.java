package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_1406 {
	private static int M; // 명령어 개수
	private static char val; // P 명령어의 삽입 data
	private static List<Character> list = new LinkedList<>(); // 입력 문자열 저장 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		String str = br.readLine();
		
		for(int i = 0;i < str.length();i++) list.add(str.charAt(i)); // String을 한 문자씩 List에 넣어줌
		ListIterator<Character> iter = list.listIterator(); // iterator로 커서를 생성해주고 맨 뒤로 이동시켜줌
		
		M = Integer.parseInt(br.readLine());
		while(iter.hasNext())  iter.next();
	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0); // 명령어 입력
			switch (command) {
			case 'L': // 커서의 위치가 맨 앞이 아니면 왼쪽으로 한 칸 이동
				if(iter.hasPrevious()) iter.previous();
				break;
			case 'D': // 커서의 위치가 맨 뒤가 아니면 오른쪽으로 한 칸 이동
				if (iter.hasNext()) iter.next();
				break;
			case 'B': // 커서의 위치가 맨 앞이 아니면 왼쪽으로 이동 후 해당 문자 제거
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P': // 해당위치에 새 문자 삽입
				val = st.nextToken().charAt(0);
				iter.add(val);
				break;
			default:
				break;
			}
		}
		for(char c : list)bw.write(c);
		bw.close();
	} 
}
