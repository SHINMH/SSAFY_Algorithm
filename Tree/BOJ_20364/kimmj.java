package Tree/BOJ_20364;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kimmj {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("inputfile/BOJ_20364.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer= new StringBuilder();
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine(), " ");
		int N= Integer.parseInt(st.nextToken());
		int Q= Integer.parseInt(st.nextToken());
		
		boolean[] tree= new boolean[N+1];
		for (int q=0; q<Q; q++) {
            
            int x= Integer.parseInt(br.readLine());
            int idx= x;
            int tmp= x;
            while(tmp>=1) {
                if (tree[tmp]) {
                    idx= Math.min(tmp, x);
                }
                tmp /= 2;
            }
            if (!tree[idx] && idx==x) {
                tree[x]= true;
                answer.append("0\n");
            } else {
                answer.append(idx + "\n");
            }
            
        }

		System.out.println(answer);
	}
}
