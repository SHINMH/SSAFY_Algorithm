package SSAFY_Algorithm.LinkedList.BOJ_1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class shinmh {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		Stack<Character> frontStack = new Stack<Character>();
		Stack<Character> backStack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			frontStack.add(str.charAt(i));
		}
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "L":
				if(frontStack.isEmpty()) break;
				backStack.add(frontStack.pop());
				break;
			case "D":
				if(backStack.isEmpty()) break;
				frontStack.add(backStack.pop());
				break;
			case "B":
				if(frontStack.isEmpty()) break;
				frontStack.pop();
				break;
			case "P":
				frontStack.add(st.nextToken().charAt(0));
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!frontStack.isEmpty()) {
			sb.append(frontStack.pop());
		}
		sb.reverse();
		while(!backStack.isEmpty()) {
			sb.append(backStack.pop());
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
