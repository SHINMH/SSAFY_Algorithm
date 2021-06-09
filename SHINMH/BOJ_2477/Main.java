package BOJ_2477;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[2][6];

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < 6; i++) {
			String[] str = br.readLine().split(" ");
			map[0][i] = Integer.parseInt(str[0]);
			map[1][i] = Integer.parseInt(str[1]);
		}

		int maxW = 0;
		int maxH = 0;
		int removeArea = 0;
		for (int i = 0; i < 6; i++) {
			if (map[0][i] == 1 || map[0][i] == 2) {
				maxW = Math.max(maxW, map[1][i]);
			}else if (map[0][i] == 3 || map[0][i] == 4) {
				maxH = Math.max(maxH, map[1][i]);
			}
			
			if(map[0][i] == map[0][(i + 2) % 6] && map[0][(i + 1) % 6] == map[0][(i + 3) % 6]) {
				removeArea = map[1][(i + 2) % 6] * map[1][(i + 1) % 6];
			}
		}	
		
		int area = (maxW * maxH - removeArea) * N;
		
		System.out.println(area);
	}
}
