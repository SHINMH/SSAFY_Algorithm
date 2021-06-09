package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[2];
		list[0] = new ArrayList<>();
		list[1] = new ArrayList<>();
		
		HashMap<Integer, Integer> tree = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int[] target = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree.put(y, x); // key : 자식 value : 부모
		}
		
		list[0].add(target[0]);
		int I = 0;
		while (true) { //list에 첫번째 사람의 조상을 저장
			Integer parentNode = tree.get(list[0].get(I++));
			if (parentNode != null) list[0].add(parentNode);
			else break;
		}

		list[1].add(target[1]);
		int J = 0;
		while (true) { // list에 두번째 사람의 조상을 저장
			Integer parentNode = tree.get(list[1].get(J++));
			if (parentNode != null) list[1].add(parentNode);
			else break;
		}
		int ans = -1;
		boolean f = false; // 조상 탐색 성공 여부 for문 탈출 flag 
		for (int i = 0; i < I; i++) { // 두 사람의 공통 조상을 검색 후 두 사람과 조상 사이의 거리를 합산
			for (int j = 0; j < J; j++) {
				if (list[0].get(i) == list[1].get(j)) {
					ans = i + j;
					f = true;
					break;
				}
			}
			if (f)
				break;
		}
		bw.write(String.valueOf(ans));
		bw.close();
	}
}
