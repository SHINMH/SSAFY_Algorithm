package SSAFY_Algorithm.Tree.BOJ_20364;

import java.io.*;
import java.util.StringTokenizer;

public class leedg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());
        int[] lands = new int[N + 1];

        for(int duck = 0; duck < Q; duck++) {
            int ori_idx = Integer.parseInt(br.readLine());
            int cpy_idx = ori_idx;
            int stuck_idx = 0;

            //점유되어 있는 첫번째 땅을 알아야하기 때문에 맨 아래에서부터 위로 탐색
            while(cpy_idx > 0) {
                //점유되어 있는 땅을 만나도 역순 탐색이며 가장 첫번째 점유된 땅을 알아내야 되기 때문에 계속 탐색
                if(lands[cpy_idx] == -1) {
                    stuck_idx = cpy_idx;
                }
                //처음부터 2를 나누지 않는 이유는 중복된 땅을 가지길 원하는 오리가 있을 수도 있기때문에 검증 필요
                cpy_idx /= 2;
            }

            //점유된 땅이 없을 경우에는 해당 오리가 원하는 땅 점유할 수 있게 해줌
            if(stuck_idx == 0) {
                lands[ori_idx] = -1;
            }
            sb.append(stuck_idx).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}