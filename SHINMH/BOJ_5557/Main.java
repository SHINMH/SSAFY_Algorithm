package BOJ_5557;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        long[][] dp = new long[N][21];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][array[0]] = 1;
        for(int i = 1; i < N - 1; i++){
            for(int j = 0; j < 21; j++){
                if(dp[i - 1][j] == 0) continue;

                if(j + array[i] >= 0 && j + array[i] <= 20){
                    dp[i][j + array[i]] += dp[i - 1][j];
                }
                if(j - array[i] >= 0 && j - array[i] <= 20){
                    dp[i][j - array[i]] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N - 2][array[N - 1]]);
    }
}
