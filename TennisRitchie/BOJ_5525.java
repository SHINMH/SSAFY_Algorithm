package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0, ans = 0;
		int i = str.indexOf('I'); // I 처음 등장 위치 검색
		while (i < L - 2) {
			if (str.charAt(i) =='I' && str.charAt(i+1) =='O' && str.charAt(i+2) =='I') { // 현위치부터 3개의 문자가 IOI일 경우 cnt + 1   
				cnt++;
				if (cnt == N) { //cnt가 N개일 경우 ans + 1하고 맨 처음 IOI 제거
					cnt--;
					ans++;
				}
				i++;
			} else cnt = 0; // IOI가 아닐 경우 cnt 0;
			i++;
		}
		bw.write(String.valueOf(ans));
		bw.close();
	}
}
