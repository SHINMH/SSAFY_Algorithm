package BOJ_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[][] map = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        int answer = 0;
        //2 ~ 100 이하 정수
        for(int i = min; i <= max; i++){
            answer = Math.max(answer, dfs(map, N, i));
        }

        System.out.println(answer);
    }

    public static int dfs(int[][] map, int N, int max){
        boolean[][] visited = new boolean[N][N];
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int count = 0;
        Queue<Pos> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] >= max){
                    queue.add(new Pos(i,j));
                    visited[i][j] = true;
                    count++;

                    while(!queue.isEmpty()){
                        Pos temp = queue.poll();
                        int ny, nx;
                        for(int k = 0; k < 4; k++){
                            ny = temp.y + dy[k];
                            nx = temp.x + dx[k];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || map[ny][nx] < max) continue;

                            queue.add(new Pos(ny, nx));
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
