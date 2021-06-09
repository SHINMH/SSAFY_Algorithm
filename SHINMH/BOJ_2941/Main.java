package BOJ_2941;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		for(String text : "c= c- dz= d- lj nj s= z=".split(" ")) {
			word = word.replaceAll(text, "0");
		}
		System.out.println(word.length());
	}
}

// 저수지의 물의 총 깊이 구하기
