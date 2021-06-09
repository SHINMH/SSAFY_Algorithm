package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer S = new StringBuffer(br.readLine());
		StringBuffer T = new StringBuffer(br.readLine());
		int size = T.length() - 1;
		work(S, T, size);
	}
	private static void work(StringBuffer S, StringBuffer T, int size) {
		if (S.length() == T.length()) {
			System.out.println(S.toString().equals(T.toString()) ? 1 : 0);
			return;
		}
		if (T.charAt(size) == 'B')
			work(S, new StringBuffer(T.substring(0, size)).reverse(), size-1);
		else
			work(S, new StringBuffer(T.substring(0, size)), size-1);
	}
}
