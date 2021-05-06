package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1062 {
	private static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String base = "acint"; // 기본 숙지 문자
		if (k < 5) // 기본 숙지 문자도 못배울 경우
			bw.write("0");
		else {
			String[] words = new String[n];
			int learnedWords = (1 << 'a' - 'a') | (1 << 'c' - 'a') | (1 << 'i' - 'a') | (1 << 'n' - 'a')
					| (1 << 't' - 'a'); // 현재 배운 문자 (기본 숙지 문자) bitmasking
			Set<Character> alphaSet = new HashSet<>(); // 새로 배울 문자들의 집합
			for (int i = 0; i < n; i++) {
				words[i] = br.readLine();
				words[i] = words[i].substring(4, words[i].length() - 4); // 접두사 접미사 제거 후 가운데 문자만 남김
				for (int j = 0; j < words[i].length(); j++) {
					if(!base.contains(Character.toString(words[i].charAt(j)))) // 기본 숙지 문자가 아닐 경우 새로 배울 문자 집합에 추가
						alphaSet.add(words[i].charAt(j));
				}
			}
			Character[] alpha = alphaSet.toArray(new Character[alphaSet.size()]); //원활한 조합 계산을 위해 set를 배열로 변환
			Combination(words, learnedWords, 0, (k > alpha.length+5)?alpha.length+5:k, alpha); // k값 고려
			bw.write(String.valueOf(max));
		}
		bw.close();
	}

	private static void Combination(String[] words, int learnedWords, int startIdx, int k, Character[] alpha) {
		if (Integer.bitCount(learnedWords) == k) { // k개 문자를 다 배움
			int cnt = 0;
			for (String word : words) { // 현재 조합에서 읽을 수 있는 단어 수 계산
				boolean f = false;
				for (int i = 0; i < word.length(); i++) {
					if ((learnedWords & (1 << (word.charAt(i) - 'a'))) == 0) {
						f = true;
						break;
					}
				}
				if (!f) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		for (int i = startIdx; i < alpha.length; i++)
			if ((learnedWords & (1 << (alpha[i] - 'a'))) == 0)
				Combination(words, learnedWords | (1 << (alpha[i] - 'a')), i + 1, k, alpha);
	}
}