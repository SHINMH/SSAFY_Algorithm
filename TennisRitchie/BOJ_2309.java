package leejh;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	static int[] arr,ans=null; 
	static boolean F = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		for(int i = 0; i < 9; i++)	arr[i] = sc.nextInt();
		Combination(0,new int[7],0,0);
		Arrays.sort(ans);
		for(int i = 0; i < 7; i++)System.out.println(ans[i]);
	}
	static void Combination(int toSelect,int[] selected, int sum, int startIdx) {
		if(sum>100) return;
		if (toSelect == 7) {
			if(sum == 100) {
				ans = Arrays.copyOf(selected,7);
			}
			return;
		}
		for (int i = startIdx; i < 9; i++) {
			selected[toSelect] = arr[i];
			Combination(toSelect + 1,selected, sum + arr[i], i + 1);
		}
	}
}
