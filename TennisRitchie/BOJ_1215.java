package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1215 {
	private static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf(code(n, k)));
		bw.close();
	}

	private static long code(int n, int k) {
		long r = 0L;
		int SqrtK= (int)Math.sqrt(k);
		int[] arr = new int[SqrtK+1];
		for(int i = 1;i<=SqrtK;i++) {
			arr[i] = (int)(k/i);
		}
		for(int i = 1;i<=n;i++) {
			if(i<SqrtK) r += i*arr[i];
			else {
				
			}
		}
		return n*k-r;
	}
}
