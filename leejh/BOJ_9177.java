package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9177 {
	private static boolean flag;
	private static boolean dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			int[] alpha = new int[90];
			String str[] = br.readLine().split(" ");
			dp = new boolean[str[0].length()][str[1].length()];
			for (int j = 0; j < str[0].length(); j++) {
				alpha[str[0].charAt(j) - 'A'] += 1;
				alpha[str[2].charAt(j) - 'A'] -= 1;
			}
			for (int j = str[0].length(); j < str[2].length(); j++) {
				alpha[str[1].charAt(j-str[0].length()) - 'A'] += 1;
				alpha[str[2].charAt(j) - 'A'] -= 1;
			}
			flag = true;
			for (int a : alpha) {
				if (a != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				flag = false;
				go(str, 0, 0, 0);
			}
			bw.write("Data set " + i + ": " + (flag ? "yes\n" : "no\n"));
		}
		bw.close();
		br.close();
	}
	private static void go(String[] str, int idxA, int idxB, int idxC) {
		if(dp[idxA][idxB]) return;
		if (idxC == str[2].length()) {
			flag = true;
			return;
		}
		if (flag || (idxA == str[0].length() && idxB == str[1].length()))
			return;
		if (idxA < str[0].length() && str[2].charAt(idxC) == str[0].charAt(idxA))
			go(str, idxA + 1, idxB, idxC + 1);
		if (idxB < str[1].length() && str[2].charAt(idxC) == str[1].charAt(idxB))
			go(str, idxA, idxB + 1, idxC + 1);
		dp[idxA][idxB] = true;
		return;
	}
}
