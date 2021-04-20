package Stack/BOJ_1662;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class kimmj {
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("inputfile/BOJ_1662.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> bracket= new Stack<>();
		Stack<Integer> count= new Stack<>();
		
		char[] arr= br.readLine().toCharArray();
		for (int i=0; i<arr.length; i++) {
			char c= arr[i];
			if (c=='(') {
				bracket.push(c);
			} else if (c==')') {
				int tmp= 0;
				while(bracket.peek()!='(') {
					tmp+=count.pop();
					bracket.pop();
				}
				bracket.pop();
				tmp*= Character.getNumericValue(bracket.pop());
				bracket.push('t');
				count.pop();
				count.push(tmp);
			} else {
				bracket.push(c);
				count.push(1);
			}
		}
		
		int answer= 0;
		while(!count.isEmpty()) {
			answer+= count.pop();
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
}
