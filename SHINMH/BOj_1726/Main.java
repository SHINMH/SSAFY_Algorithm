package BOj_1726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int y;
        int x;
        int d;
        int count;

        public Pos(int y, int x, int d, int count) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.count = count;
        }
    }

    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 세로, 가로
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * -1;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        //동 서 남 북 0 1 2 3
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        int d = Integer.parseInt(st.nextToken()) - 1;
        Pos start = new Pos(y, x, d, 0);

        st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        d = Integer.parseInt(st.nextToken()) - 1;
        Pos end = new Pos(y, x, d, 0);

        System.out.println(solution(start, end));
    }

    static int solution(Pos start, Pos end) {
        int answer = 0;

        // 각 뱡향 별로 체크
        boolean[][][] visited = new boolean[N][M][4];
        // 01 0-1 10 -10
        // 동 서 남 북
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        Queue<Pos> queue = new LinkedList<>();
        visited[start.y][start.x][start.d] = true;
        queue.add(start);

        int ny, nx;
        while(!queue.isEmpty()){
            Pos current = queue.poll();
            if(current.y == end.y && current.x == end.x && current.d == end.d){
                answer = current.count;
                break;
            }

            // 방향 돌리기
            if(current.d == 0 || current.d == 1){
                if(!visited[current.y][current.x][2]){
                    queue.add(new Pos(current.y, current.x, 2, current.count + 1));
                    visited[current.y][current.x][2] = true;
                }
                if(!visited[current.y][current.x][3]){
                    queue.add(new Pos(current.y, current.x, 3, current.count + 1));
                    visited[current.y][current.x][3] = true;
                }
            }else {
                if(!visited[current.y][current.x][0]){
                    queue.add(new Pos(current.y, current.x, 0, current.count + 1));
                    visited[current.y][current.x][0] = true;
                }
                if(!visited[current.y][current.x][1]){
                    queue.add(new Pos(current.y, current.x, 1, current.count + 1));
                    visited[current.y][current.x][1] = true;
                }
            }

            for(int i = 1; i <= 3; i++){
                ny = current.y + dy[current.d] * i;
                nx = current.x + dx[current.d] * i;

                if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == -1) break;
                if(!visited[ny][nx][current.d]){
                    queue.add(new Pos(ny, nx, current.d, current.count + 1));
                    visited[ny][nx][current.d] = true;
                }
            }
        }

        return answer;
    }
}
