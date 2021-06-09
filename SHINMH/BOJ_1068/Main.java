package BOJ_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Main {
	static int N;
	static int[] array;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int root = 0;
		for(int i = 0; i < N; i++) {	
			array[i] = Integer.parseInt(st.nextToken());
			if(array[i] == -1) root = i;
		}
		array[Integer.parseInt(br.readLine())] = -2;
		
		count = 0;
		search(root);
		System.out.println(count);
	}
	
	static void search(int node) {
		if(array[node] == -2) return;
		
		boolean leaf = true;
		for(int i = 0; i < N; i++) {
			if(array[i] == node) {
				search(i);
				leaf = false;
			}
		}
		if(leaf) {
			count++;
		}
	}
}
