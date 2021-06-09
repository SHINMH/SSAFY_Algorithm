package BOJ_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] color = new int[N][3];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++){
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] D = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            D[i][0] = color[i - 1][0] + Math.min(D[i - 1][1], D[i - 1][2]);
            D[i][1] = color[i - 1][1] + Math.min(D[i - 1][0], D[i - 1][2]);
            D[i][2] = color[i - 1][2] + Math.min(D[i - 1][0], D[i - 1][1]);
        }

        System.out.println(Math.min(D[N][0], Math.min(D[N][1], D[N][2])));
    }
}
