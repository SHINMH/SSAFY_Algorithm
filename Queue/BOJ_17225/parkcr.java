package SSAFY_Algorithm.Queue.BOJ_17225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class parkcr {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); //상민 포장시간
		int B = Integer.parseInt(st.nextToken()); //지수 포장시간
		int N= Integer.parseInt(st.nextToken()); //손님 수
		StringBuilder sbS = new StringBuilder();
		StringBuilder sbJ = new StringBuilder();
		
		int cntS=0;
		int cntJ=0;
		int num =1; //선물 번호
		for(int i=0; i<N;i++) {
			String[] tmp = br.readLine().split(" ");
			if(tmp[1].equals("B")) {//상민
				int S = Integer.parseInt(tmp[2]);
				for(int j=0;j<S;j++) {
					sbS.append((num+j)+" ");
					 cntS++;
				}
				num+=S;
			}else {//지수
				int J = Integer.parseInt(tmp[2]);
				for(int j=0;j<J;j++) {
					sbJ.append((num+j)+" ");
					cntJ++;
				}
				num+=J;
			}
		}
		System.out.println(cntS);
		System.out.println(sbS);
		System.out.println(cntJ);
		System.out.println(sbJ);
		
	}
}
