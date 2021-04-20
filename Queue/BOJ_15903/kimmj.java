package Queue/BOJ_15903;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class kimmj {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Long> cards= new PriorityQueue<>();
		
		st= new StringTokenizer(br.readLine(), " ");
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			cards.add(Long.parseLong(st.nextToken()));
		}
		
		for (int m=0; m<M; m++) {
			long sum= 0;
			sum+= cards.poll();
			sum+= cards.poll();
			cards.add(sum);
			cards.add(sum);
		}
		
		long answer= 0;
		while(!cards.isEmpty()) {
			answer+= cards.poll();
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
}
