package stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1662_Compression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String tmp = br.readLine();
		int bracket_idx = 0;
		String[] arr = new String[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			arr[i] = String.valueOf(tmp.charAt(i));
			if (arr[i].equals("(")) {
				bracket_idx++;
			}
		}
		int[] bracket = new int[bracket_idx];

		bracket_idx = 0;
		int result = 0;

		Stack<String> stack = new Stack<>();
		for (String s : arr) {
			if (!s.equals(")")) {
				if (s.equals("(")) {
					bracket_idx++;
				}
				stack.push(s);
			} else {
				bracket_idx--;
				int cnt = 0;
				while (!stack.peek().equals("(")) {
					stack.pop();
					cnt++;
				}
				stack.pop();
				cnt += bracket[bracket_idx];
				cnt *= Integer.parseInt(stack.pop());
				bracket[bracket_idx] = 0;
				if (bracket_idx - 1 < 0) {
					result += cnt;
					continue;
				}
				bracket[bracket_idx - 1] += cnt;
			}
		}
		result += stack.size();
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();

	}
}
