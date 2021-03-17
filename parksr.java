package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class parksr {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int visited_cnt = 0;
		if (row == 1 || col == 1) visited_cnt = 1;
		else if (row == 2) 	visited_cnt = Math.min(4, (col + 1) / 2);
		else if (col <= 6)	visited_cnt = Math.min(4, col);
		else visited_cnt = col - 2;
		
		bw.write(String.valueOf(visited_cnt));
		br.close(); bw.flush(); bw.close(); 
		}
}
