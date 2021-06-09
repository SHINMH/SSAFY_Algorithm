package BOJ_2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] map = new int[501][501];
            int[] isConnect = new int[501];
            final int INF = 1000;

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    map[i][j] = INF;
                }
            }

            StringTokenizer st;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine(), " ");

                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken()) ] = 1;
            }


            for(int k = 1; k <= N; k++){
                for (int i = 1; i <= N; i++){
                    for(int j = 1; j <= N; j++){
                        if(map[i][j] > map[i][k] + map[k][j]){
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            int answer = 0;
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(map[i][j] != INF){
                        isConnect[i]++;
                        isConnect[j]++;

                        if(isConnect[i] == N - 1) answer++;
                        if(isConnect[j] == N - 1) answer++;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
