package SSAFY_Algorithm.Queue.BOJ_1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class leemz {
	
	static String str;
	static int num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<String> q = new Stack<>();
		Stack<String> q2 = new Stack<>();

		str = br.readLine();

		num = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < str.length(); i++) {
			q.push(str.substring(i, i+1)); // substring : 문자열 자르기 i부터 i+1까지 
		}
		
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			
			switch(c) {
			case "L":
				if(!q.isEmpty()) {
					q2.push(q.pop());		
				}
				break;
			case "D":
				if(!q2.isEmpty()) {
					q.push(q2.pop());		
				}
				break;
			case "B":
				if(!q.isEmpty()) {
					q.pop();	
				}
				break;
			case "P":
				q.push(st.nextToken());
				break;
				
			}
			
//			if (c == "L" &&  !q.isEmpty()) { //커서를 왼쪽으로 한 칸 옮김. 단, 문장 맨앞이면 무시 
//				q.pop();
//				q2.push(q.pop());			
//
//			} else if (c == "D" && !q2.isEmpty()) { // 커서 오른쪽으로 한칸 옮김. 커서 문장 맨뒤일시 무시 
//				q.push(q2.pop());	
//			} else if (c == "B" && !q.isEmpty()) { // 커서 왼쪽 문자 삭제. 맨앞이면 무시 
//				q.pop();	
//			} else if (c == "P") { // 공백 뒤 문자 왼쪽에 추가
//				System.out.println(st.nextToken());
//				q.push(st.nextToken());
//			}else {
//				System.out.println("아무것도");
//			}
			
			
		}
		
		while(!q2.isEmpty()) {
			q.push(q2.pop());
		}
		
		System.out.println(q);



	}

}
