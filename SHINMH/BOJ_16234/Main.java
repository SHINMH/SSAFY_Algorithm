package BOJ_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int answer;

    static class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(map);

        System.out.println(answer);
    }

    static void solution(int[][] map){
        int count;
        answer = 0;

        while(true){
            boolean[][] visited = new boolean[N][N];
            count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        if(bfs(i, j, map, visited)) count++;
                    }
                }
            }

            if(count == 0) break;
            answer++;
        }
    }

    static boolean bfs(int y, int x, int[][] map, boolean[][] visited){
        Queue<Pos> queue = new LinkedList<>();
        List<Pos> list = new ArrayList<>();
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int sum = 0;

        queue.add(new Pos(y, x));
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Pos current = queue.poll();
            list.add(current);
            int value = map[current.y][current.x];
            int ny, nx;

            sum += value;

            for(int i = 0; i < 4; i++){
                ny = current.y + dy[i];
                nx = current.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;

                int curValue = Math.abs(map[ny][nx] - value);

                if(curValue >= L && curValue <= R){
                    queue.add(new Pos(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }

        for (Pos cur : list){
            map[cur.y][cur.x] = sum / list.size();
        }

        if(list.size() > 1) return true;
        return false;
    }
}
