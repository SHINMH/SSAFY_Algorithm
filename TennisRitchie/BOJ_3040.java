package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3040 {
	static int[] arr;
	static boolean Flag=false;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for(int i = 0; i < 9;i++)
			arr[i] = Integer.parseInt(br.readLine());
		combination(0,new int[7],0,0);
		bw.close();
	}
	static void combination(int toSelect, int[] selected, int startIdx, int sum) throws NumberFormatException, IOException {
		if(Flag) return;
		if(sum>100) return;
		if (toSelect == 7) {
			if(sum == 100) {
				for(int i = 0; i < 7;i++)
					bw.write(selected[i]+"\n");
			}
			return;
		}
		for (int i = startIdx; i < 9; i++) {
			selected[toSelect] = arr[i];
			combination(toSelect + 1,selected, i + 1, sum + arr[i]);
		}
	}
}
