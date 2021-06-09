package BOJ_1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int y;
        int x;
        int k;
        int count;

        public Pos(int y, int x, int k, int count) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.count = count;
        }
    }

    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solution(H, W, K);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static int solution(int H, int W, int K){
        return bfs(K, H, W);
    }

    static int bfs(int K, int H, int W){
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        int[] hy = {-2, -1, -2, -1,  2,  1, 2, 1};
        int[] hx = {-1, -2,  1,  2, -1, -2, 1, 2};

        Queue<Pos> queue = new LinkedList<>();
        visited = new boolean[H][W][K + 1];

        queue.add(new Pos(0,0, 0, 1));

        int ny, nx;
        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Pos current = queue.poll();

            if(current.x == W - 1 && current.y == H - 1){
                min = Math.min(min, current.count - 1);
                break;
            }
            //말처럼 이동
            if(current.k < K) {
                for(int i = 0; i < 8; i++){
                    ny = current.y + hy[i];
                    nx = current.x + hx[i];

                    if(!checkMove(ny, nx,current.k + 1, H, W)) continue;

                    visited[ny][nx][current.k + 1] = true;
                    queue.add(new Pos(ny, nx, current.k + 1, current.count + 1));
                }
            }

            //근접칸 이동
            for(int i = 0; i < 4; i++){
                ny = current.y + dy[i];
                nx = current.x + dx[i];

                if(!checkMove(ny, nx, current.k, H, W)) continue;

                visited[ny][nx][current.k] = true;
                queue.add(new Pos(ny, nx, current.k, current.count + 1));
            }
        }

        return min;
    }

    static boolean checkMove(int y, int x, int K, int H, int W){
        if(x < 0 || y < 0 || x >= W || y >= H) return false;
        if(map[y][x] == 1) return false;
        if(visited[y][x][K]) return false;
        return true;
    }
}
