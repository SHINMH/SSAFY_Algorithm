package BOJ.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main_2346 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		LinkedList<int[]> list = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			list.add(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		
		int index = 0;
		while(true) {
			int[] num = list.remove(index);
			System.out.print(num[0] + " ");
			int size = list.size();
			if(list.isEmpty()) break;
			if(num[1] > 0) {
				index = (index - 1 + num[1]) % size;
			}else {
				int i = Math.abs(num[1]);
				while(i > 0) {
					index--;
					if(index < 0) {
						index = size - 1;
					}
					i--;
				}
			}
		}
	}
}

