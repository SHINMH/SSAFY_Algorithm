package Stack/BOJ_2504;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class kimmj {
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("inputfile/BOJ_2504.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<String> stack= new Stack<>();
		char[] bracket= br.readLine().toCharArray();
		int answer= 0;
		
		for (int i=0; i<bracket.length; i++) {
			int tmp= 0;
			switch(bracket[i]) {
				case '(':
					if (bracket[i+1]==')') {
						stack.push("2");
						i++;
					} else {
						stack.push("(");
					}
					break;
				case '[':
					if (bracket[i+1]==']') {
						stack.push("3");
						i++;
					} else {
						stack.push("[");
					}
					break;
				case ')':
					while (!stack.isEmpty()) {
						if (stack.peek().equals("[")) {
							bw.write("0");
							br.close();
							bw.close();
							return;
						} else if (stack.peek().equals("(")) {
							stack.pop();
							stack.push(String.valueOf(tmp*2));
							break;
						} else {
							tmp+= Integer.parseInt(stack.pop());
						}
					}
					break;
				case ']':
					while (!stack.isEmpty()) {
						if (stack.peek().equals("(")) {
							bw.write("0");
							br.close();
							bw.close();
							return;
						} else if (stack.peek().equals("[")) {
							stack.pop();
							stack.push(String.valueOf(tmp*3));
							break;
						} else {
							tmp+= Integer.parseInt(stack.pop());
						}
					}
					break;
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek().equals("(") || stack.peek().equals("[")) {
				bw.write("0");
				br.close();
				bw.close();
				return;
			}
			answer+= Integer.parseInt(stack.pop());
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
}
