package leejh;

import java.util.Scanner;

public class BOJ_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		if (N < 10) {
			if (N % 2 == 0)
				System.out.println(N / 2);
			else
				System.out.println('0');
		} else {
			int ans = 0;
			int i = func(N);
			for (; i < N; i++) {
				if (fun(i) == N) {
					ans = i;
					break;}}
			System.out.println(ans);

		}
	}

	public static int fun(int n) {
		int res = n;
		String str = Integer.toString(n);
		for (int i = 0; i < str.length(); i++) {
			res += str.charAt(i) - '0';
		}
		return res;
	}

	public static int func(int n) {
		String str = Integer.toString(n);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		if (str.charAt(0) == '1' && str.charAt(1) == '0') {
			i = 2;
			sb.append(9);
		} else {
			i = 1;
			sb.append(str.charAt(0) - 1);
		}
		for (; i < str.length(); i++)
			sb.append(9);
		int sum = 0;
		for (i = 0; i < sb.length(); i++) {
			sum += sb.charAt(i) - '0';
		}
		return n - sum;

	}
}