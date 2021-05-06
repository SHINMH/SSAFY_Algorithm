package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1074 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = (int) Math.pow(2, N);
		int cnt = 0;
		
		while (true) {
			d /= 2;
			if (c >= d) {
				if (r >= d) {
					cnt += d * d * 3;
					r -= d;
					c -= d;
				} else {
					cnt += d * d;
					c -= d;
				}
			} else {
				if (r >= d) {
					cnt += d * d * 2;
					r -= d;
				}
			}
			if (d == 1) break;
		}
		bw.write(String.valueOf(cnt));
		bw.close();
	} 
}