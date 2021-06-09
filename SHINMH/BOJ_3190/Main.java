package BOJ_3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
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

    static class Direction {
        int time;
        char direction;

        public Direction(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        StringTokenizer st;
        int y, x;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
        }
        int count = Integer.parseInt(br.readLine());
        Direction[] directions = new Direction[count];

        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine(), " ");
            directions[i] = new Direction(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        Deque<Pos> snake = new LinkedList<>();
        snake.add(new Pos(0, 0));
        map[0][0] = 2;

        int time = 0;
        int derectionCount = 0;
        int direction = 0;
        while(true){
            time++;

            if(!move(direction, N, map, snake)) break;

            if(derectionCount < directions.length && time == directions[derectionCount].time){
                if(directions[derectionCount].direction == 'L'){
                    direction = (direction - 1 + 4) % 4;
                }else {
                    direction = (direction + 1) % 4;
                }
                derectionCount++;
            }
        }

        System.out.println(time);
    }
    static boolean move(int direction, int N, int[][] map, Deque<Pos> snake){
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int ny = snake.peek().y + dy[direction];
        int nx = snake.peek().x + dx[direction];

        if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 2){
            return false;
        }

        snake.addFirst(new Pos(ny, nx));
        if(map[ny][nx] == 0){
            Pos pos = snake.removeLast();
            map[pos.y][pos.x] = 0;
        }
        map[ny][nx] = 2;

        return true;
    }
}

