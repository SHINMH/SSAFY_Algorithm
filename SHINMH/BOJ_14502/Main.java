package BOJ_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static HashMap<Integer, Pos> hashMap;
    static int N;
    static int M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        hashMap = new HashMap<>();
        visited = new boolean[N][M];
        answer = Integer.MIN_VALUE;

        int count = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    hashMap.put(count++, new Pos(i, j));
                }
            }
        }

        solution();

        System.out.println(answer);
    }

    static void solution(){
        combination(0, 0, hashMap.size(), new int[3]);
    }

    static void combination(int start, int count, int size, int[] wallArea){
        if(count == 3){
            for(int ob : wallArea){
                Pos wall = hashMap.get(ob);
                map[wall.y][wall.x] = 1;
            }

            for(int i = 0; i < N; i++){
                Arrays.fill(visited[i], false);
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 2){
                        bfs(i, j);
                    }
                }
            }

            int safeArea = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j] && map[i][j] == 0) safeArea++;
                }
            }

            answer = Math.max(answer, safeArea);

            for(int ob : wallArea){
                Pos wall = hashMap.get(ob);
                map[wall.y][wall.x] = 0;
            }
            return;
        }

        for(int i = start; i < size; i++){
            wallArea[count] = i;
            combination(i + 1, count + 1, size, wallArea);
        }
    }

    static void bfs(int y, int x){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(y, x));
        visited[y][x] = true;

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int ny, nx;
        while (!queue.isEmpty()){
            Pos current = queue.poll();

            for(int i = 0; i < 4; i++){
                ny = current.y + dy[i];
                nx = current.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.add(new Pos(ny, nx));
                }
            }
        }
    }
}
