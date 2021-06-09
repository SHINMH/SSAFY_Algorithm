package SW_4014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[][] map1 = new int[N][N];
            int[][] map2 = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map1[i][j] = map2[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for(int i = 0; i < N; i++){
                result += solution(map1[i], N, X);
                result += solution(map2[i], N, X);
            }

            System.out.printf("#%d %d\n", testCase, result);
        }
    }

    static int solution(int[] map, int N, int X){
        int head = map[0];
        int count = 1;
        for(int i = 1; i < N; i++){
            //현 발판과 다음 발판이 1이상 차이나면 설치 불가
            if(Math.abs(head - map[i]) > 1) return 0;

            if(head > map[i]){ // 내리막
                if(N < i + X) return 0;
                for(int j = i; j < i + X; j++){
                    if(map[i] != map[j]) return 0;
                }
                count = -X + 1;
            }else if(head < map[i]){ // 오르막
                if(count >= X){
                    count = 1;
                }else{
                    return 0;
                }
            }else { // 같을 경우
                count++;
            }
            head = map[i];
        }
        return 1;
    }
}
