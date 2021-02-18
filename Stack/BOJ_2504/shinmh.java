package SSAFY_Algorithm.Stack.BOJ_2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class shinmh {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int score = 1;
		int sum = 0;
		boolean flag = false;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add('(');
				score *= 2;
			} else if (str.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() == '[') {
					flag = true;
					break;
				}
				if(stack.peek() == '(' && str.charAt(i - 1) == '(') {
					sum += score;
				}
				stack.pop();
				score /= 2;
			} else if (str.charAt(i) == '[') {
				stack.add('[');
				score *= 3;
			} else if (str.charAt(i) == ']') {
				if(stack.isEmpty() || stack.peek() == '(') {
					flag = true;
					break;
				}
				if(stack.peek() == '[' && str.charAt(i - 1) == '[') {
					sum += score;
				}
				stack.pop();
				score /= 3;
			}
			if(stack.isEmpty()) {
				score = 1;
			}
		}
		
		if(!stack.isEmpty()) flag = true;
		
		System.out.println(flag ? 0 : sum);
	}
}
