package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_7785 {
	private static int N;
	private static TreeSet<String> member; // treeSet으로 출근한 사원 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		member = new TreeSet<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String cmd = st.nextToken();
			if(cmd.charAt(0)=='e') member.add(name); // enter 명령어
			else member.remove(name); // leave 명령어
		}
		NavigableSet<String> sortedMember = member.descendingSet(); // 이름 내림 차순으로 정렬해줌
		for(String s : sortedMember) bw.write(s+'\n');
		bw.close();
	}
}
