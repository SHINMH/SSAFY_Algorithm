package BOJ_2234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] numberMap;
    static int[] size;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        numberMap = new int[N][M];
        size = new int[2501];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution(){
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    size[count + 1] = bfs(i, j, visited, count + 1);
                    max = Math.max(max, size[count + 1]);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
        System.out.println(merge());
    }

    static int bfs(int startY, int startX, boolean[][] visited, int num){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        numberMap[startY][startX] = num;

        int y, x;
        int[] current;
        int[] dy = {0, -1, 0, 1};
        int[] dx = {-1, 0, 1, 0};
        int ny, nx;
        int count = 0;
        while(!queue.isEmpty()){
            current = queue.poll();
            count++;
            y = current[0];
            x = current[1];

            // 서쪽 1, 북쪽 2, 동쩍 4 , 남쪽 8
            for(int i = 0; i < 4; i++){
                ny = y + dy[i];
                nx = x + dx[i];
                if(((map[y][x] & 1 << i) == 0) && !visited[ny][nx]){
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    numberMap[ny][nx] = num;
                }
            }
        }

        return count;
    }

    static int merge(){
        int ny, nx;
        int[] dy = {0, -1, 0, 1};
        int[] dx = {-1, 0, 1, 0};

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < 4; k++){
                    ny = i + dy[k];
                    nx = j + dx[k];

                    if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if(numberMap[i][j] != numberMap[ny][nx]){
                        max = Math.max(max, size[numberMap[i][j]] + size[numberMap[ny][nx]]);
                    }
                }
            }
        }

        return max;
    }
}
