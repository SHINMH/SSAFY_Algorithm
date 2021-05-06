package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2437 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		if (arr[0] != 1) bw.write("1"); // 시작인 1부터 무게를 잴 수 없으므로 1출력 후 종료
		else {
			int sum = 0; // 현재까지 만들 수 있는 최댓값
			for (int i = 0; i < N; i++) {
				if (arr[i] > sum + 1) break; // 기저조건 : 현재까지 만들 수 있는 최댓값보다 현재 추가 2이상 클 경우 sum+1 무게부터 측정 불가
				sum += arr[i];
			}
			bw.write(String.valueOf(sum + 1));
		}
		bw.close();
	}
}
