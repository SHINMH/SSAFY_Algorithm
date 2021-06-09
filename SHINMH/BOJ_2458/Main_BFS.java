package BOJ_2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BFS {
    static int[][] map;
    static int N;
    static int gtCnt;
    static int ltCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
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

            int answer = 0;
            for(int k = 1; k <= N; k++){
                gtCnt = ltCnt = 0;
                gtBFS(k, new boolean[N + 1]);
                ltBFS(k, new boolean[N + 1]);
                if(gtCnt + ltCnt == N - 1) answer++;
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void gtBFS(int start, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int k = queue.poll();
            for(int i = 1; i <= N; i++){
                if(!visited[i] && map[i][k] == 1){
                    queue.offer(i);
                    visited[i] = true;
                    ltCnt++;
                }
            }
        }
    }

    private static void ltBFS(int start, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int k = queue.poll();
            for(int i = 1; i <= N; i++){
                if(!visited[i] && map[k][i] == 1){
                    queue.offer(i);
                    visited[i] = true;
                    ltCnt++;
                }
            }
        }
    }
}
