package SSAFY_Algorithm.Tree.BOJ_20364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class parkcr {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);
		int[] land = new int[N+1];
		int result = 0;
		
		for(int q=0; q<Q;q++) {
			result=0;
			int want = Integer.parseInt(br.readLine());
			//원하는 땅이 점유하지 않은 땅이라면
			if(land[want]==0) {
				int tmp = want;
				while(tmp>3) {
					tmp = tmp%2==0?tmp/2:(tmp-1)/2;//원하는 땅(자식노드)에서 부모노드로
					if(land[tmp]!=0) result =tmp;//원하는 땅까지 가는 루트 중에 점유한 땅이 있을 때
				}
				if(result==0) {
					land[want]++;
				}
			}else {//점유한 땅을 원할 때
				int tmp2 = want;
				while(tmp2>1) {
					if(land[tmp2]!=0) result =tmp2;
					tmp2 = tmp2%2==0?tmp2/2:(tmp2-1)/2;
					if(land[tmp2]!=0) result =tmp2;
				}				
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
