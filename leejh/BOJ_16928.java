package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16928 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input[] = br.readLine().split(" ");
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] dp = new int[101];
		
		for(int i = 0 ; i < N ; ++i) {
			input = br.readLine().split(" ");
			map.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		for(int i = 0 ; i < M ; ++i) {
			input = br.readLine().split(" ");
			map.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1);
		
		while(!q.isEmpty() && dp[100]==0) {
				int cur = q.poll();
				for(int i = 1 ; i <= 6 ; ++i) {
					int next = cur + i;
					if(next > 100) continue;
					if(map.containsKey(next) && dp[map.get(next)]==0) {
						dp[map.get(next)] = dp[cur] + 1;
						dp[next] = dp[cur] + 1;
						q.offer(map.get(next));
					}
					else if(!map.containsKey(next) && dp[next]==0) {
						dp[next] = dp[cur] + 1;
						q.offer(next);
					}
					if(next==100) break;
				}
			}
		bw.write(String.valueOf(dp[100]));
		bw.close();
	}
}