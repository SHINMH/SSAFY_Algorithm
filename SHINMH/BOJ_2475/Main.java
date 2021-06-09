package BOJ_2475;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		long result = 0;
		for(int i = 0; i < 5; i++) {
			result += Long.parseLong(str[i]) * Long.parseLong(str[i]);
		}
		System.out.println(result%10);
	}
}
