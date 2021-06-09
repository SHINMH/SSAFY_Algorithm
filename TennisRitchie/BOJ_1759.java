package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/*암호생성기*/
public class BOJ_1759 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static BufferedReader br;
	private static int N, L;
	private static char lastMother; // 입력 문자열에 포함되어있는 가장 큰 모음
	private static char[] str;
	private final static String mother = "aeiou"; // 모음 저장

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 암호 자리수 입력
		L = Integer.parseInt(st.nextToken()); // 사용 문자열 길이

		str = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) { // 사용할 문자열 입력
			str[i] = st.nextToken().charAt(0);
			if (mother.contains(Character.toString(str[i]))) // 해당 문자가 모음인지 판별
				lastMother = (char) Math.max(lastMother, str[i]); // 문자열에 포함되어있는 모음 중 최대값을 넣어줌
		}
		Arrays.sort(str); // 오름차순으로 sort
		combination(0, new char[N], 0, 0); // 암호 생성 조합 함수
		bw.close();
	}
	private static void combination(int toSelect, char[] selected, int startIdx, int motherCnt) throws IOException {
		if (toSelect == N) { // 암호 완성 후 유효성 검사
			if (N - motherCnt < 2 || motherCnt == 0) // 모음이 0개 or 자음이 2개 이하일 경우 예외 처리
				return;
			for (char c : selected) // 암호 출력
				bw.write(c);
			bw.write("\n");
			return;
		}
		for (int i = startIdx; i < L; i++) {
			if (motherCnt == 0 && str[i] > lastMother) //모음이 한 개도 나오지 않았는데 모음보다 큰 자음에 access한 경우 예외 처리
				return;
			selected[toSelect] = str[i]; // 암호 문자열 추가
			combination(toSelect + 1, selected, i + 1,
					(mother.contains(Character.toString(str[i]))) ? motherCnt + 1 : motherCnt);
		}
	}
}
