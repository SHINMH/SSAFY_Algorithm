package BOj_10836;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(map[i], 1);
        }

        int[] growth = new int[3];
        int[] growthArray = new int[N * 2];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            growth[0] = Integer.parseInt(st.nextToken());
            growth[1] = Integer.parseInt(st.nextToken());
            growth[2] = Integer.parseInt(st.nextToken());

            int y = N - 1;
            int x = 0;

            for(int k = 0; k < 3; k++){
                for(int j = 0; j < growth[k]; j++){
                    map[y][x] += k;
                    if(y > 0){
                        y--;
                    }else{
                        x++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == 0 || j == 0){
                    sb.append(map[i][j] + " ");
                }else {
                    sb.append(Math.max(map[i][0], map[0][j]) + " ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
