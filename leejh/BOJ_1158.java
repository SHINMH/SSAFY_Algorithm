package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder answer = new StringBuilder();

		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int pos = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++)
			list.add(i);
		int idx = 1;
		int cnt = 0;
		bw.write("<");
		while(true) {
			if(cnt==list.size()) cnt = 0;
			if(list.size() == 1) {
				bw.write(String.valueOf(list.get((0))));
				break;
			}
			else {
				if(idx%pos==0) {
					bw.write(list.get(cnt)+", ");
					list.remove(cnt);
					idx = 0;
				}
				else cnt++;
			}
			idx++;
			
		}
		bw.write(">");
		bw.flush();
	}
}
