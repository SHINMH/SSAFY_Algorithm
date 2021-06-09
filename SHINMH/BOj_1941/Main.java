package BOj_1941;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        answer = 0;

        solution();

        System.out.println(answer);
    }

    static void solution(){
        combination(0, 0, 0, new boolean[25]);
    }

    static void combination(int start, int count, int s, boolean[] visited){
        int x = 0, y = 0;
        if(count == 7){
            // 이다솜 파가 4이하면 안해도 됨.
            if(s >= 4){
                boolean[][] checked = new boolean[N][N];
                boolean[][] isVisited = new boolean[N][N];

                for(int i = 0; i < 25; i++){
                    if(visited[i]){
                        y = i / 5;
                        x = i % 5;
                        checked[y][x] = true;
                    }
                }
                if(dfs(y, x, checked, isVisited) == 7){
                    answer++;
                }
            }
            return;
        }

        for(int i = start; i < 25; i++){
            visited[i] = true;
            y = i / 5;
            x = i % 5;
            if(map[y][x] == 'S'){
                combination(i + 1, count + 1, s + 1, visited);
            }else {
                combination(i + 1, count + 1, s, visited);
            }
            visited[i] = false;
        }
    }

    static int dfs(int y, int x, boolean[][] checked, boolean[][] isVisited){
        isVisited[y][x] = true;
        int result = 1;
        int ny, nx;
        for(int i = 0; i < 4; i++){
            ny = y + dy[i];
            nx = x + dx[i];
            if(ny >= 0 && ny < N && nx >= 0 && nx < N && checked[ny][nx] && !isVisited[ny][nx]){
                result += dfs(ny, nx, checked, isVisited);
            }
        }
        return result;
    }
}
