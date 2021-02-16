package SSAFY_Algorithm.Stack.BOJ_1662;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class leejh {
	static String zipped_str = null; // 압축된 문자열 저장
	static Stack<Integer> stack = null;
	final static int openParentheses = -1; // 여는 괄호

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		zipped_str = br.readLine();

		int K = 0, Q = 0, res = 0;
		stack = new Stack<>();
		for (int i = 0; i < zipped_str.length(); i++) { // K(Q)일 때 Q에 문자열이아닌 문자열 개수를 넣어줌
			if (zipped_str.charAt(i) == ')') { // 닫히는 괄호를 만났을 때
				Q = 0;
				while (stack.peek() > openParentheses) // 괄호 안의 문자열 개수를 구함
					Q += stack.pop();
				stack.pop(); // 여는 괄호 제거
				K = stack.pop(); // K값 저장
				Q *= K; // 압축된 문자열을 풀어준다.
				stack.push(Q); // 압축이 풀린 문자열의 길이를 다시 스택에 push
			} else if (zipped_str.charAt(i) == '(') // 여는 괄호를 만나면 stack이 Integer를 담고 있기 때문에 -1을 push
				stack.push(openParentheses);
			else { // 정수를 만났을 대
				if (i < zipped_str.length() - 1 && zipped_str.charAt(i + 1) == '(') // ( 바로 앞에 온 한자리 수는 K를 의미하는 정수이므로 정수값을 스택에 push
					stack.push(zipped_str.charAt(i) - '0');
				else // 위 경우를 제외한 모든 정수는 문자열이기 때문에 한 문자열의 길이인 1을 push
					stack.push(1);
			}
		}
		while (!stack.isEmpty()) // 스택에 남아있는 문자열은 압축이 풀린 문자열 -> 스택 안의 문자열 길이를 res에 넣어줌
			res += stack.pop();
		bw.write(String.valueOf(res));
		bw.close();
	}
}
