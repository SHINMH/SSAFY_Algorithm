package BOJ_17472;

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

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static List<Pos>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬의 수를 세고, 해당 섬에서 다른 섬을 연결하는 루트를 계산한다.
        solution();
    }

    static void solution(){
        list = new ArrayList[6];
        int number = 1;
        for(int i = 0; i < 6; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, number++);
                }
            }
        }
        number--;

        int[][] array = new int[number][number];
        int[] distance = new int[number];
        boolean[] visitedVertex = new boolean[number];
        Arrays.fill(distance, Integer.MAX_VALUE);

        calDistance(array, number);

        distance[0] = 0;
        int result = 0;

        for(int c = 0; c < number; c++){
            int min = Integer.MAX_VALUE;
            int minVertex = 0;
            for(int i = 0; i < number; i++){
                if(!visitedVertex[i] && min > distance[i]){
                    minVertex = i;
                    min = distance[i];
                }
            }

            if(min == Integer.MAX_VALUE){
                result = -1;
                break;
            }

            result += min;
            visitedVertex[minVertex] = true;

            for(int i = 0; i < number; i++){
                if(!visitedVertex[i] && array[minVertex][i] != 0 && distance[i] > array[minVertex][i]){
                    distance[i] = array[minVertex][i];
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int y, int x, int number){
        Queue<Pos> queue = new LinkedList<>();
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        queue.add(new Pos(y, x));
        visited[y][x] = true;

        int ny, nx;
        while(!queue.isEmpty()){
            Pos current = queue.poll();
            map[current.y][current.x] = number;
            list[number - 1].add(current);
            for(int i = 0; i < 4; i++){
                ny = current.y + dy[i];
                nx = current.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                queue.add(new Pos(ny, nx));
            }
        }
    }

    static void calDistance(int[][] array, int size){
        int distance;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                if(i == j) array[i][j] = 0;
                else array[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                for(Pos start : list[i]){
                    for(Pos end : list[j]){
                        distance = 0;
                        boolean flag = false;
                        if (start.x == end.x){
                            int index = start.y;
                            int sub = start.y - end.y > 0 ? -1 : 1;
                            index += sub;
                            while(index != end.y){
                                if(map[index][start.x] != 0){
                                    flag = true;
                                    break;
                                }
                                distance++;
                                index += sub;
                            }
                        }else if(start.y == end. y){
                            int index = start.x;
                            int sub = start.x - end.x > 0 ? -1 : 1;
                            index += sub;
                            while(index != end.x){
                                if(map[start.y][index] != 0){
                                    flag = true;
                                    break;
                                }
                                distance++;
                                index += sub;
                            }
                        }
                        if(distance <= 1 || flag) continue;
                        array[i][j] = Math.min(array[i][j], distance);
                        array[j][i] = array[i][j];
                    }
                }
            }
        }
    }
}
