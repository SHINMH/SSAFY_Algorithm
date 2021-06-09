package BOJ_12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];
        int[][] D = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(weight[i] <= j){
                    D[i][j] = Math.max(D[i - 1][j], D[i-1][j - weight[i]] + value[i]);
                }else{
                    D[i][j] = D[i-1][j];
                }
            }
        }
        System.out.println(D[N][K]);
    }
}
