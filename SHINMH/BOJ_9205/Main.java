package BOJ_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine()) + 2;
            int[][] array = new int[N][2];
            boolean[][] distance = new boolean[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                array[i][0] = Integer.parseInt(st.nextToken());
                array[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(Math.abs(array[i][0] - array[j][0]) + Math.abs(array[i][1] - array[j][1]) <= 1000){
                        distance[i][j] = true;
                    }else{
                        distance[i][j] = false;
                    }
                }
            }

            for(int mid = 0; mid < N; mid++){
                for(int start = 0; start < N; start++) {
                    for (int end = 0; end < N; end++) {
                        if(distance[start][mid] && distance[mid][end]){
                            distance[start][end] = true;
                        }
                    }
                }
            }

            System.out.println(distance[0][N - 1] ? "happy" : "sad");
        }
    }
}
