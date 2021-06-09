package BOJ_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] answer = solution();
        System.out.println(answer[0] + " " + answer[1]);
    }

    static int[] solution(){
        boolean[][] visited = new boolean[N][N];
        boolean[][] uncomVisited = new boolean[N][N];

        int[] count = new int[]{0, 0};
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]) {
                    dfs(i, j, visited, false, map[i][j]);
                    count[0]++;
                }
                if(!uncomVisited[i][j]){
                    dfs(i, j, uncomVisited, true, map[i][j]);
                    count[1]++;
                }
            }
        }
        return count;
    }

    static void dfs(int startY, int startX, boolean[][] visited, boolean uncomfortable, char color){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        int ny, nx;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i = 0; i < 4; i++){
                ny = current[0] + dy[i];
                nx = current[1] + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;

                if(!uncomfortable){
                    if(color == map[ny][nx]){
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }else{
                    if(color == 'B'){
                        if(color == map[ny][nx]){
                            queue.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }else{
                        if(map[ny][nx] == 'R' || map[ny][nx] == 'G'){
                            queue.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
    }
}
