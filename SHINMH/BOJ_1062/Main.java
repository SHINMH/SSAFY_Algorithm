package BOJ_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] list;
    static boolean[] wordList;
    static int N, K;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new boolean[N][26];
        wordList = new boolean[26];

        answer = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                list[i][str.charAt(j) - 'a'] = true;
                wordList[str.charAt(j) - 'a'] = true;
            }
        }

        if(K < 5){
            System.out.println(0);
        }else{
            solution();

            System.out.println(answer);
        }
    }

    static void solution(){

        boolean[] usedWord = new boolean[26];
        usedWord['a' - 'a'] = true;
        usedWord['n' - 'a'] = true;
        usedWord['t' - 'a'] = true;
        usedWord['c' - 'a'] = true;
        usedWord['i' - 'a'] = true;

        makeCombination(0, 5, usedWord);
    }

    static void makeCombination(int start, int count, boolean[] word){
        if(count == K){
            answer = Math.max(answer, countWord(word));

            return;
        }

        for(int i = start; i < 26; i++){
            if(!word[i]){
                word[i] = true;
                makeCombination(i + 1, count + 1, word);
                word[i] = false;
            }
        }
    }

    static int countWord(boolean[] word){
        int count = 0;
        for(int i = 0; i < N; i++){
            boolean flag = true;
            for(int j = 0; j < 26; j++){
                if(list[i][j] && !word[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }

        return count;
    }
}
