package SSAFY_Algorithm.DFS_BFS.BOJ_7576;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class leedg {
    private static final int[] dir_x = {-1, 0, 1, 0};
    private static final int[] dir_y = {0, -1, 0, 1};
    private static class TomatoInfo {
        int row;
        int col;
        int day;
        public TomatoInfo(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<TomatoInfo> Q = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());
        int[][] WareHouse = new int[N][M];
        int answer = 0, blankCnt = 0, tomatoCnt = 0;


        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                WareHouse[i][j] = Integer.parseInt(stk.nextToken());
                if(WareHouse[i][j] == 1) {
                    Q.add(new TomatoInfo(i, j, answer));
                } else if(WareHouse[i][j] == -1) {
                    blankCnt++;
                }
            }
        }

        while(!Q.isEmpty()) {
            TomatoInfo tomato = Q.poll();
            answer = tomato.day;
            tomatoCnt++;
            for(int i = 0; i < 4; i++) {
                int nr = tomato.row + dir_x[i];
                int nc = tomato.col + dir_y[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if(WareHouse[nr][nc] == 0) {
                    WareHouse[nr][nc] = 1;
                    Q.add(new TomatoInfo(nr, nc, tomato.day + 1));
                }
            }
        }

        if(tomatoCnt == (M * N) - blankCnt) sb.append(answer);
        else sb.append(-1);
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}
