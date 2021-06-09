package BOJ_2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_DFS_memo {
    static int[][] map;
    static int N;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                map[i][0] = -1;
            }

            StringTokenizer st;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map[start][end] = 1;
            }


            for(int k = 1; k <= N; k++){
                if(map[k][0] == -1) dfs(k);
            }

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    map[0][i] += map[j][i];
                }
            }

            int answer = 0;
            for(int i = 1; i <= N; i++){
                if(map[i][0] + map[0][i] == N - 1) answer++;
            }


            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void dfs(int cur){
        for(int i = 1; i <= N; i++){
            if(map[cur][i] == 1){

                if(map[i][0] == -1) dfs(i); // 아직 탐색하지 않은 학생이면 탐색하러 가기
                // i 학생을 탐색하고 왔거나, 이미 탐색이 되어있어서 탐색하지 않고 내려옴.
                if(map[i][0] > 0) { // i학생보다 큰 학생이 있다면
                    for(int j = 1; j <= N; j++){
                        if(map[i][j] == 1) map[cur][j] = 1;
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++) cnt += map[cur][i];

        map[cur][0] = cnt;
    }
}
