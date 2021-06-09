package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_2504 {
	private static String str; // 입력 문자열
	private final static int openBigKwalho = -1; // [
	private final static int openSmallKwalho = -2; // { 
	private static Stack<Integer> stack = new Stack<>(); //문자열 괄호 계산을 위한 stack

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		str = br.readLine();
		boolean Flag = true; // 괄호 유효성 검사
		int res = 0; // 결과값 저장 변수
		for (int i = 0; i < str.length(); i++) { // 문자열 1번 순회
			int sum = 0; // 괄호 안의 정수들의 합 저장
			if (str.charAt(i) == ')') { // 닫힌 소괄호 만남
				if (i > 0 && str.charAt(i - 1) == '(') { // 닫힌 소괄호를 만나고 직전의 문자열이 (이면 
					stack.pop(); //stack에서 (를 제거하고
					stack.push(2); // ()의 값인 2를 대신 넣어줌++++
				} else { // (가 아니라 다른 값을 만났다면
					while (!stack.isEmpty() && stack.peek() > 0) // 괄호를 만나거나 stack이 비기 전까지 존재하는 수를 sum에 더해줌
						sum += stack.pop();
					if ((!stack.isEmpty() && stack.peek() == openBigKwalho) || (stack.isEmpty())) { // stack이 비었거나 열린 대괄호를 만났을 시 괄호 유효성 검사 오류
						Flag = false;
						break;
					}
					stack.pop(); // 열린 소괄호 ( 제거
					stack.push(sum * 2); // ()안의 정수 값들의 합 * 2
				}
			} else if (str.charAt(i) == ']') { // 닫힌 대괄호를 만남
				if (i > 0 && str.charAt(i - 1) == '[') {// 닫힌 대괄호를 만나고 직전의 문자열이 [이면 
					stack.pop(); // 괄호 제거
					stack.push(3); // [] 값인 3을 대신 넣어줌
				} else { // [가 아니라 다른 값을 만났다면
					while (!stack.isEmpty() && stack.peek() > 0) // 괄호를 만나거나 stack이 비기 전까지 존재하는 수를 sum에 더해줌
						sum += stack.pop();
					if ((!stack.isEmpty() && stack.peek() == openSmallKwalho) || (stack.isEmpty())) {// stack이 비었거나 열린 소괄호를 만났을 시 괄호 유효성 검사 오류
						Flag = false;
						break;
					}
					stack.pop();
					stack.push(sum * 3);
				}
			} else { // 열린 괄호를 만났을 때
				if (str.charAt(i) == '(') stack.push(openSmallKwalho); // 열린 소괄호를 만났다면 문자 ( 대신 -2을 저장
				else stack.push(openBigKwalho); // 열린 대괄호를 만났다면 문자 [를 대신 -1를 저장
			}
		}
		while (!stack.isEmpty()) { // stack 남아있는 수를 모두 더해줌 
			if ( stack.peek() < 0) { // 괄호를 만나면 유효성 검사 오류
				Flag = false;
				break;
			}
			res += stack.pop();
		}
		if (!Flag) res = 0; // 괄호가 유효하지 않을 때 0 출력
		bw.write(String.valueOf(res)); // 괄호가 유효할 경우 결과 출력
		bw.close();
	}
}