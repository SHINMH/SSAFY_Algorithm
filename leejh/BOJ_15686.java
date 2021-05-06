package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Pos1{
	int row,col;
	Pos1(int row,int col){
		this.row = row;
		this.col = col;
	}
}
public class BOJ_15686 {
	static int N,M,ans=999999;
	static ArrayList<Pos1> home = new ArrayList<>();
	static ArrayList<Pos1> store = new ArrayList<>();
	static Pos1[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new Pos1[M];
		for(int row = 0; row<N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; col++) {
				char temp = st.nextToken().charAt(0);
				if(temp == '1') home.add(new Pos1(row,col));
				else if(temp == '2') store.add(new Pos1(row,col));
			}
		}
		combination(0,0);
		
		bw.write(String.valueOf(ans));
		bw.close();
	}
	private static void combination(int cnt,int start) {
		if(cnt == M) {
			int sum = 0;
			for(Pos1 h : home) {
				int dist = 999999;
				for(int i = 0;i<M;i++) 
					dist = Math.min(dist,Math.abs(h.row-selected[i].row) + Math.abs(h.col-selected[i].col));
				sum += dist;
				if(sum > ans) return;
			}
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=start; i<store.size(); ++i) {
			selected[cnt] = store.get(i);
			combination(cnt+1,i+1);
		}
	}
}
