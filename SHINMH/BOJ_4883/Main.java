package BOJ_4883;

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while(true){
            if((N = Integer.parseInt(br.readLine())) == 0) break;
            int[][] map = new int[N][3];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 3; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            map[0][2] = map[0][1] + map[0][2];
            map[1][0] = map[1][0] + map[0][1];
            map[1][1] = map[1][1] + Math.min(map[1][0], Math.min(map[0][1], map[0][2]));
            map[1][2] = map[1][2] + Math.min(map[1][1], Math.min(map[0][1], map[0][2]));

            for(int i = 2; i < N; i++){
                map[i][0] = map[i][0] + Math.min(map[i - 1][0], map[i - 1][1]);
                map[i][1] = map[i][1] + Math.min(map[i][0], Math.min(map[i - 1][0], Math.min(map[i-1][1], map[i-1][2])));
                map[i][2] = map[i][2] + Math.min(map[i][1], Math.min(map[i - 1][1], map[i-1][2]));
            }
            sb.append(testCase + ". " + map[N-1][1]+"\n");
            testCase++;
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
