package BOJ_3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int[][] waterflood;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        waterflood = new int[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }
        flood();
        int result = bfs();

        System.out.println(result != 0 ? result : "KAKTUS");
    }

    static void flood(){
        Queue<int[]> water = new LinkedList<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == '*'){
                    water.add(new int[]{i, j, 0});
                }
                waterflood[i][j] = Integer.MAX_VALUE;
            }
        }

        boolean[][] visited = new boolean[R][C];
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        while(!water.isEmpty()){
            int[] current = water.poll();

            int ny, nx;
            for(int i = 0; i < 4; i++){
                ny = current[0] + dy[i];
                nx = current[1] + dx[i];
                if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || map[ny][nx] != '.') continue;
                water.add(new int[]{ny, nx, current[2] + 1});
                waterflood[ny][nx] = current[2] + 1;
                visited[ny][nx] = true;
            }
        }
    }

    static int bfs(){
        boolean[][] visited = new boolean[R][C];

        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'S'){
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    flag = true;
                }
            }
            if(flag) break;
        }

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(map[current[0]][current[1]] == 'D'){
                return current[2];
            }

            int ny, nx;
            for(int i = 0; i < 4; i++){
                ny = current[0] + dy[i];
                nx = current[1] + dx[i];
                if(ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[ny][nx]){
                    if((map[ny][nx] == '.' && waterflood[ny][nx] > current[2] + 1) || map[ny][nx] == 'D'){
                        queue.add(new int[]{ny, nx, current[2] + 1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return 0;
    }
}
