package SW_1263;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            int[][] array = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                min = Math.min(min, dijkstra(i, N, array));
            }
            sb.append("#" + tc + " " + min + "\n");
        }
        System.out.println(sb.toString());
    }

    static int dijkstra(int start, int N, int[][] array){
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for(int c = 0; c < N; c++){
            int min = Integer.MAX_VALUE;
            int current = 0;
            for(int i = 0; i < N; i++){
                if(!visited[i] && min > distance[i]){
                    min = distance[i];
                    current = i;
                }
            }

            visited[current] = true;
            //if(current == end) break; // 도중에 끝낼때

            for(int i = 0; i < N; i++){
                if(!visited[i] && array[current][i] != 0 && min + array[current][i] < distance[i]){
                    distance[i] = min + array[current][i];
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += distance[i];
        }
        return sum;
    }
}
