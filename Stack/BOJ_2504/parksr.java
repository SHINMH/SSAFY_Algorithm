package SSAFY_Algorithm.Stack.BOJ_2504;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/* BufferedWriter 써보기!*/
public class parksr {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String tmp = br.readLine();
		String[] arr = new String[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			arr[i] = String.valueOf(tmp.charAt(i));
		}

		Stack<String> stack = new Stack<>();
		String bracket = "()[]";

		for (String c : arr) {
			if (c.equals("(") || c.equals("[")) {
				stack.push(c);
			}
			else {
				if (stack.isEmpty()) break;
				if (stack.peek().equals("(") || stack.peek().equals("[")) {
					if (c.equals(")") && stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					} else if (c.equals("]") && stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					}
					else {
						stack.clear();
						break;
					}
				}
				else {
					int sum = 0;
					while (!stack.isEmpty() && !bracket.contains(stack.peek())) {
						sum += Integer.parseInt(stack.pop());
					}
					if (stack.isEmpty()) break;
					if (c.equals(")") && stack.peek().equals("(")) {
						stack.pop();
						stack.push(Integer.toString(sum * 2));
					} else if (c.equals("]") && stack.peek().equals("[")) {
						stack.pop();
						stack.push(Integer.toString(sum * 3));
					}
					else {
						stack.clear();
						break;
					}
				}
			}
		}
		int total = 0;
		if(!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				if (bracket.contains(stack.peek())) {
					total = 0;
					break;
				}
				total += Integer.parseInt(stack.pop());
			}
		}
		bw.write(String.valueOf(total));

		br.close();
		bw.flush();
		bw.close();
	}
}
