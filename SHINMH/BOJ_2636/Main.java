package BOJ_2636;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        int[] answer = new int[2];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) answer[1]++;
            }
        }


        solution(map, H, W, answer);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static int[] solution(int[][] map, int H, int W, int[] answer){
        int count;
        while(true){
            // 치즈 지우기
            answer[0]++;

            bfs(0, 0, H, W, map, new boolean[H][W]);

            count = 0;
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(map[i][j] == 1) count++;
                }
            }

            if(count == 0) break;
            answer[1] = count;
        }

        return answer;
    }

    static boolean bfs(int y, int x, int H, int W, int[][] map, boolean[][] visited){
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};

        Queue<Pos> queue = new LinkedList<>();
        Queue<Pos> delete = new LinkedList<>();
        queue.add(new Pos(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Pos current = queue.poll();

            int ny, nx;
            for(int i = 0; i < 4; i++){
                ny = current.y + dy[i];
                nx = current.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= H || nx >= W || visited[ny][nx]) continue;

                if(map[ny][nx] == 0){
                    queue.add(new Pos(ny, nx));
                    visited[ny][nx] = true;
                }
                else if(map[ny][nx] == 1){
                    delete.add(new Pos(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }

        if(delete.size() == 0) return false;
        for(Pos cur : delete){
            map[cur.y][cur.x] = 0;
        }
        return true;
    }
}
