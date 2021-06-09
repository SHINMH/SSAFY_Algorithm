package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1992 {
	static int n;
	static String[] str;
	static BufferedWriter bw;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		str = new String[n];
		for (int i = 0; i < n; i++) str[i] = br.readLine();
		Quard(0, 0, n);
		bw.close();
	}

	private static void Quard(int row, int col, int N) throws IOException {
		if (N > 0) {
			if (check(row, col, N))
				bw.write(str[row].charAt(col));
			else {
				N >>= 1;
				bw.write('(');
				Quard(row, col, N);
				Quard(row, col + N, N);
				Quard(row + N, col, N);
				Quard(row + N, col + N, N);
				bw.write(')');
			}
		}
	}

	private static boolean check(int row, int col, int N) {
		char temp = str[row].charAt(col);
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				if (temp != str[i].charAt(j))
					return false;
			}
		}
		return true;
	}
}
