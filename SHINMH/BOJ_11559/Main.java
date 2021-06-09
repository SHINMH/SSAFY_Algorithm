package BOJ_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Puyo {
        int y;
        int x;
        char color;

        public Puyo(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];

        StringTokenizer st;
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        answer = 0;
        solution();

        System.out.println(answer);
    }

    static void solution() {
        while (true) {
            int count = 0;
            visited = new boolean[12][6];
            for (int j = 0; j < 6; j++) {
                for (int i = 11; i >= 0; i--) {
                    if (!visited[i][j] && map[i][j] != '.') {
                        if (bfs(i, j)) count++;
                    }
                }
            }
            if (count == 0) return;
            answer++;

            for (int j = 0; j < 6; j++) {
                for (int i = 10; i >= 0; i--) {
                    for (int k = 11; k > i; k--) {
                        if (map[i][j] != '.' && map[k][j] == '.') {
                            map[k][j] = map[i][j];
                            map[i][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static boolean bfs(int y, int x) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        Queue<Puyo> queue = new LinkedList<>();
        Queue<Puyo> delete = new LinkedList<>();
        queue.add(new Puyo(y, x, map[y][x]));
        visited[y][x] = true;

        int count = 0;
        //같이 터지는 것을 찾음
        while (!queue.isEmpty()) {
            Puyo current = queue.poll();
            delete.add(current);
            count++;

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                ny = current.y + dy[i];
                nx = current.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6) continue;

                if (!visited[ny][nx] && current.color == map[ny][nx]) {
                    queue.add(new Puyo(ny, nx, current.color));
                    visited[ny][nx] = true;
                }
            }
        }

        //터지는 거 표시
        if (count >= 4) {
            while (!delete.isEmpty()) {
                Puyo current = delete.poll();
                map[current.y][current.x] = '.';
            }
            return true;
        }
        return false;
    }
}
