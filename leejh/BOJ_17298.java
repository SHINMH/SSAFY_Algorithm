package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
	private static int N;
	private static int[] arr;
	private static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			if (stack.isEmpty() || arr[stack.peek()] > arr[i])
				stack.push(i);
			else {
				while (!stack.isEmpty())
					arr[stack.pop()] = arr[i];
			}
		}
		for(int i = 0;i<N;i++) bw.write(arr[i]+" ");
		bw.close();
	}
}
