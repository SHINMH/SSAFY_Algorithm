package BOJ_5525;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		char[] word = br.readLine().toCharArray();
		int answer = 0;
		
		for(int i = 1; i < S; i++) {
			if(word[i - 1] == 'I') {
				int count = 0;
				while(i < S - 1 && word[i] == 'O' && word[i+1] == 'I'){
					i += 2;
					count++;
					if(count == N) {
						answer++;
						count--;
					} 
				}
			}
		}
		
		System.out.println(answer);
	}
}
