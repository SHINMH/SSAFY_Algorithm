package leejh;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class BOJ_5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String cmd = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			input = input.substring(1,input.length()-1);
			String arr[] = new String[N];
			st = new StringTokenizer(input,",");
			for(int i = 0; st.hasMoreTokens();i++) arr[i]=st.nextToken();
			boolean flag = true, error = true; // 뒤집기 구분
			int start = 0, end = N ;
			for (int i = 0; i < cmd.length(); i++) {
				switch (cmd.charAt(i)) {
				case 'R':
					flag = !flag;
					break;
				case 'D':
					if (start >= end) {
						error = false;
						break;
					}
					if (flag) start++;
					else end--;
				}
			}
			if (!error) {
				bw.write("error\n");
				continue;
			}
			if(flag) {
				bw.write("[");
				for(int i =start;i<end;i++) {
					bw.write(arr[i]);
					if(i !=end-1) bw.write(",");
				}
				bw.write("]\n");
			}
			else {
				bw.write("[");
				for(int i = end-1; i >= start; i--) {
					bw.write(arr[i]);
					if(i !=start) bw.write(",");
				}
				bw.write("]\n");
			}
		}
		bw.close();
	}
}
