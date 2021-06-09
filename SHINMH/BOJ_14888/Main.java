package BOJ_14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] oper;
	static int[] num;
	static int N;
	static List<Long> answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		oper = new int[4]; // + - * /
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new ArrayList<>();
		
		calculate(num[0], 1);
		
		System.out.println(Collections.max(answer));
		System.out.println(Collections.min(answer));
	}
	
	static void calculate(long result, int count) {
		if(count == N) {
			answer.add(result);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(oper[i] > 0) {
				oper[i]--;
 				switch(i) {
 				case 0:
 					calculate(result + num[count], count + 1);
 					break;
 				case 1:
 					calculate(result - num[count], count + 1);
 					break;
 				case 2:
 					calculate(result * num[count], count + 1);
 					break;
 				case 3:
 					calculate(result / num[count], count + 1);
 					break;
 				}
				oper[i]++;
			}
		}
	}
}
