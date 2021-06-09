package BOj_1592;

import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		
		int i = 0;
		int count = 0;
		while(true) {
			array[i]++;
			if(array[i] == M) break;
			count++;
			if(array[i] % 2 == 1) {
				i = (i + L) % N;
			}else {
				i = (i + N - L) % N;
			}
		}
		System.out.println(count);
	}
}
