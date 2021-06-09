package SW_1263;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            int[][] array = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#" + tc + " " + floydWarshall(array, N) + "\n");
        }
        System.out.println(sb.toString());
    }

    static int floydWarshall(int[][] array, int N){
        int[][] distance = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) distance[i][j] = 0;
                else if(array[i][j] != 0) distance[i][j] = array[i][j];
            }
        }

        for(int k = 0; k < N; k++){ // 경유지
            for(int i = 0; i < N; i++){ //출발지
                if(i == k) continue;
                for(int j = 0; j < N; j++){ //도착지
                    if(j != i && j != k && distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE){
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            int sum = 0;
            for (int j = 0; j < N; j++){
                sum += distance[i][j];
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}
