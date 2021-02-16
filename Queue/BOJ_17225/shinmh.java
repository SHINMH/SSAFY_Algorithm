package SSAFY_Algorithm.Queue.BOJ_17225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Present {
	int index;
	char color;
	
	public Present(int index, char color) {
		super();
		this.index = index;
		this.color = color;
	}
}

public class shinmh {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int N = Integer.parseInt(str[2]);
		PriorityQueue<Present> pq = new PriorityQueue<Present>((p1,p2) ->{ 
			if(p1.index == p2.index) {
				return p1.color - p2.color;
			} else {
				return p1.index > p2.index ? 1 : -1;
			}
		});
		
		int a_time = 1;
		int b_time = 1;
		int start, count;
		char color;
		for(int k = 0; k < N; k++) {
			str = br.readLine().split(" ");
			start = Integer.parseInt(str[0]);
			color = str[1].charAt(0);
			count = Integer.parseInt(str[2]);
			
			if(color == 'B') {
				a_time = Math.max(start, a_time);
				for(int i = 0; i < count; i++) {
					pq.add(new Present(a_time, color));
					a_time += A;
				}
			}
			else {
				b_time = Math.max(start, b_time);
				for(int i = 0; i < count; i++) {
					pq.add(new Present(b_time, color));
					b_time += B;
				}
			} 
		}
		
		Queue<Integer> aQueue = new LinkedList<Integer>();
		Queue<Integer> bQueue = new LinkedList<Integer>();
		
		count = 1;
		while(!pq.isEmpty()){
			Present pr = pq.poll();
			if(pr.color == 'B') {
				aQueue.add(count++);
			}else {
				bQueue.add(count++);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(aQueue.size()).append("\n");
		while(!aQueue.isEmpty()) {
			sb.append(aQueue.poll() + " ");
		}
		sb.append("\n");
		sb.append(bQueue.size()).append("\n");
		while(!bQueue.isEmpty()) {
			sb.append(bQueue.poll() + " ");
		}
		sb.append("\n");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
