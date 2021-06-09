package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BOJ_10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet bitSet = new BitSet();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
            bitSet.set(Integer.parseInt(st.nextToken()) + 10000000); // 음수 -> 양수 입력값의 비트를 1로 set
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) // 해당 수의 bit가 set되어있는지 확인
            	bw.write(bitSet.get(Integer.parseInt(st.nextToken()) + 10000000)?"1 ":"0 ");
		bw.close();
	}
}

/*public class BOJ_10815 { // 이진 탐색으로 구현
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr1[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(arr1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			bw.write(Arrays.binarySearch(arr1, Integer.parseInt(st.nextToken()););>=0?"1 ":"0 ");
		bw.close();
	}
}*/