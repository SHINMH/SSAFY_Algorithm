package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1182 {
	static int N,S,res=0;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		combination(0, 0, 0);
		bw.write(String.valueOf(res));
		bw.close();
	}

	static void combination(int toSelect, int startIdx, int sum) {
		if (toSelect > 0)
			if(sum==S) res += 1;
		if (toSelect == N)
			return;
		for (int i = startIdx; i < N; i++)
			combination(toSelect + 1, i + 1, sum + arr[i]);
	}
}