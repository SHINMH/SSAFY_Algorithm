package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_3107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(":");
		ArrayList<String> ans = new ArrayList<>();
		int index = -1;
		for (int i = 0; i < input.length; i++) {
			String in = input[i];
			if (in.equals("")) {
				index = (i > 0 && input[i-1].equals(""))?i-1:i;
			} else {
				while (in.length() < 4) 
					in = "0" + in;
				ans.add(in);
			}
		}
		while (ans.size() < 8) {
			if (index != -1)
				ans.add(index, "0000");
			else
				ans.add("0000");
		}
		bw.write(String.join(":", ans));
		bw.close();
	}
}
