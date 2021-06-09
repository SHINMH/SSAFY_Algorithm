package SW_1868;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (str.charAt(j) == '*') {
                        map[i][j] = -1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

            System.out.println("#" + tc + " " + solution());
        }
    }

    static int solution() {
        countBoom();
        boolean[][] visited = new boolean[N][N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    bfs(i, j, visited);
                    answer++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != -1) answer++;
            }
        }

        return answer;
    }

    static void countBoom() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == -1) continue;
                int count = 0;
                for (int k = i - 1; k < i + 2; k++) {
                    for (int l = j - 1; l < j + 2; l++) {
                        if (k < 0 || k >= N || l < 0 || l >= N) continue;
                        if (map[k][l] == -1) count++;
                    }
                }
                map[i][j] = count;
            }
        }
    }

    static void bfs(int Y, int X, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Y, X});
        visited[Y][X] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = y - 1; i < y + 2; i++) {
                for (int j = x - 1; j < x + 2; j++) {
                    if (i < 0 || i >= N || j < 0 || j >= N || visited[i][j]) continue;
                    if (map[i][j] == 0) queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
    }
}
