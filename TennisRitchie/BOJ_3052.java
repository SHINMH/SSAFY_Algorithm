package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long bitmask = 0;
		for (int i = 0; i < 10; i++)
			bitmask |= ((long)1 << (Integer.parseInt(br.readLine()) % 42));
		bw.write(String.valueOf(Long.bitCount(bitmask)));
		bw.close();
	}

}
