package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		kmp(S, P);
	}
	static int[] makeTable(String p) {
		int psize = p.length();
		int[] table = new int[psize];
		int j = 0;
		for (int i = 1; i < psize; i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = table[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) 
				table[i] = ++j;
		}
		return table;
	}
	static void kmp(String parent, String pattern) {
		int[] table = makeTable(pattern);
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int j = 0;
		for (int i = 0; i < parentSize; i++) {
			while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (parent.charAt(i) == pattern.charAt(j)) {
				if (j == patternSize - 1) {
					System.out.println(1);
					return;
				} else {
					j++;
				}
			}
		}
		System.out.println(0);
	}
}