package BOJ_16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] shark;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        shark = new int[4]; // y, x, level, eat
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9){
                    shark[0] = i; // y
                    shark[1] = j; // x
                    shark[2] = 2;
                    map[i][j] = 0;
                }
            }
        }

        solution();
    }

    static void solution(){
        int time = 0;
        while(checkFish() != 0){
            time += eatFish();
        }
        System.out.println(time);
    }

    static int eatFish(){
        //물고기 먹는데 걸리는 시간
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pos1, pos2)->{
            if(pos1[2] == pos2[2]){
                if(pos1[0] == pos2[0]){
                    return pos1[1] - pos2[1];
                }else{
                    return pos1[0] - pos2[0];
                }
            }
            return pos1[2] - pos2[2];
        });
        visited[shark[0]][shark[1]] = true;
        priorityQueue.add(new int[]{shark[0], shark[1], 0}); //현 사크위치, y, x, 거리

        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        int ny, nx;
        while(!priorityQueue.isEmpty()){
            int[] current = priorityQueue.poll();
            
            if(map[current[0]][current[1]] != 0 && map[current[0]][current[1]] < shark[2]){
                shark[0] = current[0];
                shark[1] = current[1];
                shark[3]++;
                map[current[0]][current[1]] = 0;
                //먹이를 먹으면 크기랑 같은 수까지 먹으면 사이즈가 커짐
                if(shark[2] == shark[3]){
                    shark[2]++;
                    shark[3] = 0;
                }

                return current[2];
            }

            for(int i = 0; i < 4; i++){
                ny = current[0] + dy[i];
                nx = current[1] + dx[i];

                //맵 범위, 물고기가 더 큼
                if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] > shark[2] || visited[ny][nx]) continue;
                priorityQueue.add(new int[] {ny, nx, current[2] + 1});
                visited[ny][nx] = true;
            }
        }
        return 0;
    }

    static int checkFish(){
        //먹을 수 있는 몰고기 수
        int count = 0;
        //먹을 수 있는 물고기
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[]{shark[0], shark[1]}); //현 사크위치
        visited[shark[0]][shark[1]] = true;

        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        int ny, nx;
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++){
                ny = current[0] + dy[i];
                nx = current[1] + dx[i];

                //맵 범위, 물고기가 더 큼
                if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] > shark[2] || visited[ny][nx]) continue;
                if(shark[2] > map[ny][nx] && map[ny][nx] != 0) count++;
                queue.add(new int[] {ny, nx});
                visited[ny][nx] = true;
            }
        }

        return count;
    }
}
