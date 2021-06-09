package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BOJ_11478 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> set = new HashSet(); // subString 중복 없이 저장
		String str = br.readLine(); // 문자열 입력
		int length = str.length(); // 문자열 길이
		for (int i = 0; i < length; i++)
			for (int j = i + 1; j <= length; j++)
				set.add(str.substring(i, j)); // substring set에 추가

		bw.write(String.valueOf(set.size())); // 결과 출력
		bw.close();
	}
}
