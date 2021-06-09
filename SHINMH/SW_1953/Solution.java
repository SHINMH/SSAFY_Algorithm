package SW_1953;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Pos {
        int r;
        int c;
        int time;

        public Pos(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N;
    static int M;
    static int L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + tc + " " + solution(R, C, map));
        }
    }

    static int solution(int R, int C, int[][] map){
        boolean[][] pipe = new boolean[8][4];
        // 파이프가 갈 수 있는 곳 표시, 상 좌 하 우
        pipe[1] = new boolean[]{true, true, true, true};
        pipe[2] = new boolean[]{true, false, true, false};
        pipe[3] = new boolean[]{false, true, false, true};
        pipe[4] = new boolean[]{true, false, false, true};
        pipe[5] = new boolean[]{false, false, true, true};
        pipe[6] = new boolean[]{false, true, true, false};
        pipe[7] = new boolean[]{true, true, false, false};

        boolean[][] visited = new boolean[N][M];

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(R, C, 1));
        visited[R][C] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        int nr, nc;
        int count = 0;
        while(!queue.isEmpty()){
            Pos current = queue.poll();
            if(current.time > L) continue;
            count++;

            for(int i = 0; i < 4; i++){
                nr = current.r + dr[i];
                nc = current.c + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) continue;
                if (pipe[map[nr][nc]][(i + 2) % 4] && pipe[map[current.r][current.c]][i]){
                    queue.add(new Pos(nr, nc, current.time + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        return count;
    }
}
