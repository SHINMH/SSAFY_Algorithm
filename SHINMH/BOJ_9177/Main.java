package BOJ_9177;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String[] word = new String[3];
            int[] wordSize = new int[3];
            for(int j = 0; j < 3; j++){
                word[j] = st.nextToken();
                wordSize[j] = word[j].length();
            }
            boolean[][] usedWord = new boolean[201][201];

            if(solution(0, 0, 0, word, usedWord, wordSize)){
                System.out.println("Data set " + i + ": yes");
            }else {
                System.out.println("Data set " + i + ": no");
            }
        }
    }

    public static boolean solution(int x, int y, int sum, String[] word, boolean[][] usedWord, int[] wordSize){
        if(wordSize[2] == sum){
            return true;
        }
        if(usedWord[x][y]) return false;

        usedWord[x][y] = true;

        if(x < wordSize[0] && word[0].charAt(x) == word[2].charAt(sum) && y < wordSize[1] && word[1].charAt(y) == word[2].charAt(sum)){
            return solution(x + 1, y, sum + 1, word, usedWord, wordSize) || solution(x, y + 1, sum + 1, word, usedWord, wordSize);
        } else if(x < wordSize[0] && word[0].charAt(x) == word[2].charAt(sum)) {
            return solution(x + 1, y, sum + 1, word, usedWord, wordSize);
        } else if(y < wordSize[1] && word[1].charAt(y) == word[2].charAt(sum)) {
            return solution(x, y + 1, sum + 1, word, usedWord, wordSize);
        }else {
            return false;
        }
    }
}
