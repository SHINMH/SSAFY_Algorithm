package BOJ_2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_DFS {
    static int[][] map;
    static int[][] map_reverse;
    static int N;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            map_reverse = new int[N + 1][N + 1];
            final int INF = 1000;

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    map[i][j] = INF;
                }
            }

            StringTokenizer st;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map[start][end] = 1;
                map_reverse[end][start] = 1;
            }

            int answer = 0;
            for(int k = 1; k <= N; k++){
                cnt = 0;
                dfs(k, new boolean[N + 1], map);
                dfs(k, new boolean[N + 1], map_reverse);
                if(cnt == N - 1) answer++;
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void dfs(int cur, boolean[] visited, int[][] adj){
        visited[cur] = true;
        for(int i = 1; i <= N; i++){
            if(!visited[i] && adj[cur][i] == 1){
                dfs(i, visited, adj);
                cnt++;
            }
        }
    }
}
