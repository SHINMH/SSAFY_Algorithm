package BOJ_3985;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine()); // 케이크
		int N = Integer.parseInt(br.readLine()); // 사람
		// 케이크 가장 왼쪽이 1 오른쪽이 L번, 사람 1~N까지 번호가 있다.
		// P번부터 K번까지 원한다.
		int[] array = new int[L];
		int[] max = new int[2];
		int[] maxCount = new int[2];
		
		for(int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]) - 1;
			int end = Integer.parseInt(str[1]) - 1;

			if(end - start > max[1]) {
				max[0] = i;
				max[1] = end - start;
			}
			
			int count = 0;
			for(int j = start; j <= end; j++) {
				if(array[j] == 0) {
					array[j] = i;
					count++;
				}
			}
			if(maxCount[1] < count) {
				maxCount[0] = i;
				maxCount[1] = count;
			}
		}
		System.out.println(max[0]);
		System.out.println(maxCount[0]);
	}
}
