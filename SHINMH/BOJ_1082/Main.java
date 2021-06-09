package BOJ_1082;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] array;
    static String[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int money = Integer.parseInt(br.readLine());

        dp = new String[51]; // 인덱스에 해당하는 금액으로 만들 수 있는 최대 번호

        solution(money);

        System.out.println(dp[money] == null ? "0" : dp[money]);
    }

    static void solution(int money){
        //dp -> 해당 금액으로 만들 수 있는 가장 큰수
        for(int i = 1; i < N; i++){
            for(int j = array[i]; j <= 50; j++){ // 0 // 1 2 10 5/ dp 10 - 5 있는지 확인
                dp[j] = Integer.toString(i);
            }
        }

        // 금액으로 만들수 있는 수 만들기
        for(int i = 1; i <= 50; i++){ //돈
            for(int j = 0; j < N; j++){ // 살수 있는 번호
                if(i - array[j] < 0) continue;
                if(dp[i - array[j]] == null) continue;
                dp[i] = max(dp[i - array[j]] + j, dp[i]);
            }
        }
    }

    static String max(String str1, String str2){
        if(str1.length() == str2.length()){
            if(str1.compareTo(str2) > 0) return str1;
            else return str2;
        }else if(str1.length() > str2.length()){
            return str1;
        }
        return str2;
    }
}
