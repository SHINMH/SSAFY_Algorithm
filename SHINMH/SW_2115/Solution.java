package SW_2115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, C;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " " + getMaxBenefit());
        }
    }

    private static int getMaxBenefit() {
        return processConbination();
    }

    private static int processConbination() {
        int result = 0, aBenefit = 0, bBenefit = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0;  j <= N - M ; j++){ // 첫열부터 연속된 m개 채취가 가능한 열까지, 일꾼A의 선택
                // 선택된 M개벌통에서 얻을 수 있는 최대 이익
                maxSum = 0;
                makeMaxSubset(i, j, 0, 0, 0);
                aBenefit = maxSum;

                // 일군 B의 선택
                // 일꾼 A와 같은 행에 뒷쪽 열부터 선택
                maxSum = 0;
                for(int j2 = j+M; j2 <= N - M; j2++){
                    makeMaxSubset(i, j2, 0, 0, 0);
                }
                // 일꾼 A의 다음행부터 선택
                for(int i2 = i + 1; i2 < N; i2++){
                    for(int j2 = 0; j2 <= N-M; j2++){
                        makeMaxSubset(i2, j2, 0, 0, 0);
                    }
                }

                if(result < aBenefit + maxSum) result = aBenefit + maxSum;
            }
        }
        return result;
    }

    private static int maxSum = 0;
    private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum){
        if(sum > C) return;
        //기저조건, 마지막 원소까지 다 부분집합을 만듬
        if(cnt == M){
            if(maxSum < powerSum) maxSum = powerSum;
            return;
        }

        //선택
        makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powerSum + (map[i][j] * map[i][j]));
        //비선택
        makeMaxSubset(i, j + 1, cnt + 1, sum, powerSum);
    }
}
