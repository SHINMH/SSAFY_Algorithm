package SSAFY_Algorithm.LinkedList.BOJ_2346;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ParkSeRyeong {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int index = 0;
		int inBalloon = arr[0];
		arr[0] = 0;
		sb.append(1).append(" ");

		for (int i = 0; i < N - 1; i++) {
			if (inBalloon < 0) {
//				index += (N + inBalloon);
//				index %= N;
				for (int j = 0; j < Math.abs(inBalloon); j++) {
					if (index == 0)
						index = N;
					index--;
					if (arr[index] == 0) {
						j--;
					}
				}
			} else {
//				index += (inBalloon % N);
//				index %= N;
				for (int j = 0; j < inBalloon; j++) {
					if (index == N - 1)
						index = -1;
					index++;
					if (arr[index] == 0) {
						j--;
					}
					
				}
			}
			sb.append(index + 1).append(" ");
			inBalloon = arr[index];
			arr[index] = 0;
		}
		bw.write(String.valueOf(sb));
		br.close();
		bw.flush();
		bw.close();
	}
}
