package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kimmj {
	
	static HashMap<Integer,Integer> map;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine(), " ");
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		
		map= new HashMap<>();
		for (int i=0; i<N+M; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		count= 0;
		bfs();
		
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
		
	}
	
	private static void bfs() {
		
		Queue<Integer> queue= new LinkedList<>();
		boolean[] board= new boolean[101];
		
		queue.offer(1);
		board[1]= true;
		
		while(!queue.isEmpty()) {
			
			int size= queue.size();
			for (int s=0; s<size; s++) {
				
				if (queue.peek()==100) {
					return;
				}
				
				for (int i=0; i<=6; i++) {
					int next= queue.peek()+i;
					if (next>100) {
						break;
					}
					if (board[next]) {
						continue;
					}
					if (map.containsKey(next)) {
						board[next]= true;
						if (board[map.get(next)]) {
							continue;
						}
						next= map.get(next);
					}
					queue.offer(next);
					board[next]=true;
				}
				queue.poll();
			}
			count++;
		}
		
	}
	
}
