package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BOJ_2230_수고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int arr[] = new int[N];
		for(int i = 0; i < N;i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int index = 1;
		for(int i = 0;i < N-1;i++) {
			if(i>0 && arr[i-1] == arr[i]) continue;
			index = Arrays.binarySearch(arr, index, N-1, arr[i]+M);
			if(index < 0) index = index * -1 - 1;
			int diff = arr[index]-arr[i];
			if(diff >= M && min > diff) min = diff;
            if(diff == M) break;
		}
		System.out.println(min);
	}
}
