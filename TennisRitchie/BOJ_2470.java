package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(input[i]);
		Arrays.sort(nums);

		if (nums[n - 1] <= 0) bw.write(nums[n - 2] + " " + nums[n - 1]);
		else if (nums[0] >= 0) bw.write(nums[0] + " " + nums[1]);
		else {
			int start = 0, end = n - 1, min = Integer.MAX_VALUE, temp;
			int[] ans = new int[2];
			while (start < end) {
				temp =nums[start] + nums[end];
				if (min > Math.abs(temp)) {
					min = Math.abs(temp);
					ans[0] = nums[start];
					ans[1] = nums[end];
				}
				if (temp < 0)
					start++;
				else
					end--;
			}
			bw.write(ans[0] + " " + ans[1]);
		}
		bw.close();
	}
}
