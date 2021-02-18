package SSAFY_Algorithm.Stack.BOJ_1662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class shinmh {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Integer> stack = new Stack<>();
		
		int i = str.length() - 1;
		while(i >= 0) {
			if(str.charAt(i) == ')') {
				stack.add(-1);
			}else if(str.charAt(i) == '(') {
				int sum = 0;
				while(!stack.isEmpty() && stack.peek() != -1) {
					sum += stack.pop();
				}
				stack.pop();
				i--;
				stack.add((str.charAt(i) - '0') * sum);
			}else {
				stack.add(1);
			}
			i--;
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
