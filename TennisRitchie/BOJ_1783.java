package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1783 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		if(n==1) bw.write("1");
		else if(n==2)
			bw.write(String.valueOf(Math.min(4, (int)((m+1)/2))));
		else
			bw.write(String.valueOf((m<7)?Math.min(4, m):m-2));
		bw.close();
	}
}
