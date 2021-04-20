package LinkedList/BOJ_2346;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class kimmj {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N= Integer.parseInt(br.readLine());
		LinkedList<Balloon> balloons= new LinkedList<>();
		st= new StringTokenizer(br.readLine(), " ");
		for (int n=0; n<N; n++) {
			balloons.add(new Balloon(Integer.parseInt(st.nextToken()), n+1));
		}
		
		int cur= 0;
		int next= 0;
		while(balloons.size()>0) {
			cur= next;
			bw.write(balloons.get(cur).idx + " ");
			next+= balloons.get(cur).val;
			if (next>cur)
				next--;
			balloons.remove(cur);
			if (balloons.size()==0)	break;
			while (next<0 || next>=balloons.size()) {
				next= (next+balloons.size()) % balloons.size();
			}
		}
		br.close();
		bw.close();
	}
	
	private static class Balloon {
		int val;
		int idx;
		
		public Balloon(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}
	}
	
}
