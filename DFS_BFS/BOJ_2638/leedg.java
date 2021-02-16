package SSAFY_Algorithm.DFS_BFS.BOJ_2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class leedg {
    private static int N, M;
    private static boolean[][] visited;
    private static int[][] arr;
    private static final int[] dir_x = {0, 1, 0, -1};
    private static final int[] dir_y = {1, 0, -1, 0};
    private static class PosInfo {
        int row, col;
        public PosInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        String input;
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            input = br.readLine();
            for(int j = 0, idx = 0; j < M; j++, idx += 2) {
                arr[i][j] = input.charAt(idx) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        int size, nx, ny, x, y, answer = -1;
        PosInfo inf;
        Deque<PosInfo> Q = new LinkedList<>();
        Q.add(new PosInfo(0, 0));
        visited[0][0] = true;

        while(!Q.isEmpty()) {
            size = Q.size();
            while(--size >= 0) {
                inf = Q.poll();
                x = inf.row;
                y = inf.col;
                for(int i = 0; i < 4; i++) {
                    nx = x + dir_x[i];
                    ny = y + dir_y[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

                    if(arr[nx][ny] >= 1) {
                        arr[nx][ny]++;
                        if(arr[nx][ny] > 2) {
                            visited[nx][ny] = true;
                            arr[nx][ny] = 0;
                            Q.addLast(new PosInfo(nx, ny));
                        }
                    } else {
                        size++;
                        Q.addFirst(new PosInfo(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}