package BOJ_12904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String startWord = br.readLine();
        String word = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(word);

        System.out.println(solution(startWord, sb) ? 1 : 0);
    }

    static boolean solution(String startWord, StringBuilder sb){
        if(startWord.length() == sb.length()){
            for(int i = 0; i < startWord.length(); i++){
                if(startWord.charAt(i) != sb.charAt(i)){
                   return false;
                }
            }
            return true;
        }

        if(sb.charAt(sb.length() - 1) == 'A'){
            sb.setLength(sb.length() - 1);
            return solution(startWord, sb);
        }else {
            sb.setLength(sb.length() - 1);
            sb.reverse();
            return solution(startWord, sb);
        }
    }
}
