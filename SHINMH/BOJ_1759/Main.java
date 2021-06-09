package Main_1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] text;
	static int L;
	static int C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		L = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		// 최소 모음 하나, 최소 자음 두개로 이루어진 문자열, 만들기
		text = new char[C];
		str = br.readLine().split(" ");
		for(int i = 0; i < C; i++) {
			text[i] = str[i].charAt(0);
		}
		Arrays.sort(text);
		combination(0, 0, new char[L]);
	}
	
	static public void combination(int count, int index, char[] word) {
		if(count == L) {
			int j = 0; // 자음
			int m = 0; // 모음
			for(int i = 0; i < L; i++) {
				if("aieou".contains(Character.toString(word[i]))) {
					m++;
				} else {
					j++;
				}
			}
			
			if(m >= 1 && j >= 2) {
				System.out.println(word);
			}
			return;
		}
		
		for(int i = index; i < C; i++) {
			word[count] = text[i];
			combination(count + 1, i + 1, word);
		}
	}
}
