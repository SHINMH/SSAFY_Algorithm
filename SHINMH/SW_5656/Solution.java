package SW_5656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Wall {
        int r;
        int c;
        int num;

        public Wall(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }

    static int N;
    static int H;
    static int W;
    static int min;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            solution(0, map);
            System.out.println("#" + t + " " + min);
        }
    }

    static boolean solution2(int count, int[][] map) {
        int result = getRemain(map);
        if(result == 0){
            min = 0;
            return true;
        }

        if(count == N){
            min = Math.min(min, result);
            return false;
        }

        int[][] newMap = new int[H][W];

        for(int c = 0; c < W; c++){
            //해당 열에 구슬을 떨어뜨려 맞는 벽돌 찾기
            int r = 0;
            while(r < H && map[r][c] == 0) r++;
            if(r == H){ // 맞는 벽돌 없음 (모두 빈칸)
                continue;
            }else {
                // 기존 count - 1의 상태로 구술 초기화
                copy(map, newMap);
                // 벽돌 깨뜨리기
                bfs(r, c, newMap);
                // 벽돌 내리기 (깨지고 난 빈 공간 처리)
                down(newMap);
                // 다음 구슬 던지기
                if(solution2(count + 1, newMap)) return true;
            }
        }
        return false;
    }

    static void solution(int count, int[][] map) {
        if(count == N){
            int result = getRemain(map);
            min = Math.min(min, result);
            return;
        }

        int[][] newMap = new int[H][W];

        for(int c = 0; c < W; c++){
            //해당 열에 구슬을 떨어뜨려 맞는 벽돌 찾기
            int r = 0;
            while(r < H && map[r][c] == 0) r++;
            if(r == H){ // 맞는 벽돌 없음 (모두 빈칸)
                solution(count + 1, map);
            }else {
                // 기존 count - 1의 상태로 구술 초기화
                copy(map, newMap);
                // 벽돌 깨뜨리기
                bfs(r, c, newMap);
                // 벽돌 내리기 (깨지고 난 빈 공간 처리)
                down(newMap);
                // 다음 구슬 던지기
                solution(count + 1, newMap);
            }
        }
    }

    static int getRemain(int[][] map){
        int count = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(map[i][j] > 0) count++;
            }
        }
        return count;
    }

    static void down(int[][] map){
        for(int c = 0; c < W; c++){
            int r = H - 1;
            //모두 빈칸이면 내릴거 없음.
            while(r >= 0 && map[r][c] == 0) r--;
            if(r < 0) continue; //모두 빈칸일 경우
            r = H - 1;
            while(r > 0){ // 자신의 위치에 내리기
                if(map[r][c] == 0){ // 빈칸이면
                    // 직전부터 위쪽 탐색하며 가장 가까운 벽돌 찾기
                    int nr = r - 1;
                    while(nr > 0 && map[nr][c] == 0) nr--;
                    map[r][c] = map[nr][c];
                    map[nr][c] = 0;
                }
                r--;
            }
        }
    }

    static void copy(int[][] map, int[][] newMap){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                newMap[i][j] = map[i][j];
            }
        }
    }

    static void bfs(int r, int c, int[][] map) {
        //가장 위쪽
        Queue<Wall> queue = new LinkedList<>();
        if(map[r][c] > 1){
            queue.add(new Wall(r, c, map[r][c]));
        }
        map[r][c] = 0; //제거

        while (!queue.isEmpty()) {
            Wall current = queue.poll();

            int nr, nc;
            for(int d = 0; d < 4; d++){
                nr = current.r;
                nc = current.c;
                //해당 칸의 수보다 1적게 반복
                for(int k = 1; k < current.num; k++){
                    nr += dr[d];
                    nc += dc[d];
                    if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0){
                        if(map[nr][nc] > 1){
                            queue.add(new Wall(nr, nc, map[nr][nc]));
                        }
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }
}
