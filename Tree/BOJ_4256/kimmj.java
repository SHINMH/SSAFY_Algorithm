package Tree/BOJ_4256;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class kimmj {
	
	static int N;
	static int[] preorder;
	static int[] inorder;
	static StringBuilder answer= new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			N= Integer.parseInt(br.readLine());
			
			preorder= new int[N];
			st= new StringTokenizer(br.readLine(), " ");
			for (int n=0; n<N; n++) {
				preorder[n]= Integer.parseInt(st.nextToken());
			}
			
			inorder= new int[N];
			st= new StringTokenizer(br.readLine(), " ");
			for (int n=0; n<N; n++) {
				inorder[n]= Integer.parseInt(st.nextToken());
			}
			
			postorder(0, N, 0);
			answer.append("\n");
			
		}
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	
	
    public static void postorder(int start, int end, int root) {
        for(int i=start; i<end; i++) {
            if(inorder[i] == preorder[root]) {
                postorder(start, i, root+1);
                postorder(i+1, end, root+i-start+1);
                answer.append(preorder[root] + " ");
            }
        }       
    }
}
