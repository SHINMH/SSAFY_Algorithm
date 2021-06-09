package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
	static int[] arr;
	static int N,M,max=0;
	static int sum = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; st.hasMoreTokens(); i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		Combination(0,0,0);
		System.out.println(max);
		
	}
	static void Combination(int toSelect, int startIdx, int sum) {
		if(sum > M) return;
		if (toSelect == 3) { 
			max = Math.max(max,sum);
			return;
		}
		for (int i = startIdx; i < N; i++) Combination(toSelect + 1,  i + 1,sum+arr[i]);
	}
}
