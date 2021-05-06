package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_2846_오르막길 {
	private static int N, max = 0, start = 0, end = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int height=0;
		st = new StringTokenizer(br.readLine());
		start=end = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			height = Integer.parseInt(st.nextToken());
			if(height > end) {
				 end=height ;
				 max = Math.max(max, end-start);
			}
			else if(height <= end) 
				start = end = height;
		}
		System.out.println(max);
		
	}
}
