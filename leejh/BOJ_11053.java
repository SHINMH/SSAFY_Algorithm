package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			String input[] = br.readLine().split(" ");
			int[] A = new int[N];
			int[] L = new int[N];
			for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input[i]);
			int size = 0;
			for(int i = 0; i < N;i++) {
				int idx = Arrays.binarySearch(L,0,size, A[i]);
				if(idx<0) idx = idx*(-1)-1;
				L[idx] = A[i];
				if(idx == size) size++;
			}
			System.out.println(size);
	}
}