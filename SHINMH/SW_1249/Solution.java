package SW_1249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static int N, INF = Integer.MAX_VALUE;
    static int map[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int t = 1; t <= TC; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                char[] ch = br.readLine().toCharArray();
                for(int j = 0; j < N; j++){
                    map[i][j] = ch[j] - '0';
                }
            }
            System.out.println("#" + t + " " + dijkstra(0, 0));
        }
    }

    private static int dijkstra(int startR, int startC){
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        // 방문거리 배열 초기화
        for(int i = 0; i < N; i++){
            Arrays.fill(minTime[i], INF);
        }
        // 시작 정점 거리 초기화
        minTime[startR][startC] = 0;

        int r = 0, c = 0, cost = 0, nr, nc;
        while(true){
            //방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
            cost = INF;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && cost > minTime[i][j]){
                        cost = minTime[i][j];
                        r = i;
                        c = j;
                    }
                }
            }
            // 선택된 최소 정점 방문 처리
            visited[r][c] = true;
            if(r == N - 1 && c == N - 1) return cost;
            // 선택된 정점기준으로 인접한 정점 중 방문하지 않은 정점들을 자신과 경유시의 비용과
            // 기존 최소비용 비교하여 최소값 업데이트
            for(int i = 0; i < 4; i++){
                nr = r + dr[i];
                nc = c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
                    && minTime[nr][nc] > cost + map[nr][nc]) {
                    minTime[nr][nc] = cost + map[nr][nc];
                }
            }
        }
    }

    private static int dijkstraPQ(int startR, int startC){
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        // 방문거리 배열 초기화
        for(int i = 0; i < N; i++){
            Arrays.fill(minTime[i], INF);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((ob1, ob2)->{
            return ob1[2] - ob2[2];
        });

        // 시작 정점 거리 초기화
        minTime[startR][startC] = 0;
        queue.offer(new int[]{startR, startC, minTime[startR][startC]});

        int r = 0, c = 0, cost = 0, nr, nc;
        while(true){
            //방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
            int[] current = queue.poll();
            r = current[0];
            c = current[1];
            cost = current[2];


            if(visited[r][c]) continue;
            // 선택된 최소 정점 방문 처리
            visited[r][c] = true;
            if(r == N - 1 && c == N - 1) return cost;

            // 선택된 정점기준으로 인접한 정점 중 방문하지 않은 정점들을 자신과 경유시의 비용과
            // 기존 최소비용 비교하여 최소값 업데이트
            for(int i = 0; i < 4; i++){
                nr = r + dr[i];
                nc = c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
                        && minTime[nr][nc] > cost + map[nr][nc]) {
                    queue.offer(new int[] {nr, nc, cost + map[nr][nc]});
                }
            }
        }
    }
}
