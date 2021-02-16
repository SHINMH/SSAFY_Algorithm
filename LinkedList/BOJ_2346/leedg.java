package SSAFY_Algorithm.LinkedList.BOJ_2346;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class leedg {
    private static class BallonInfo {
        int ballonIdx;
        int moveIdx;
        public BallonInfo(int ballonIdx, int moveIdx) {
            this.ballonIdx = ballonIdx;
            this.moveIdx = moveIdx;
        }
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cur_idx = 0;
        ArrayList<BallonInfo> list = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            list.add(new BallonInfo(i, Integer.parseInt(stk.nextToken())));
        }

        while(true) {
            BallonInfo ballon = list.get(cur_idx);
            int ballonIdx = ballon.ballonIdx;
            int moveIdx = ballon.moveIdx;

            sb.append(ballonIdx).append(" ");
            list.remove(cur_idx);
            int size = list.size();

            if(size == 0) break;

            //움직임이 왼쪽이면
            if(moveIdx < 0) {
                //타겟 idx를 움직여야하는 것에서 리스트의 사이즈를 mod해줌
                cur_idx += (moveIdx % size);
            } else {
                //오른쪽인 경우에는 현재 하나 터트려서 idx가 오른쪽으로 밀려있으니까 하나 빼주고 mod해줌
                cur_idx += (moveIdx % size) - 1;
            }

            //계산해준 결과값이 리스트 길이 초과할 수 있는 경우 다시 한번 나눠줌
            if(cur_idx >= size) {
                cur_idx %= size;
            } else if(cur_idx < 0) {
                //음수의 값이 나오면 맨끝 idx인 리스트 사이즈에서 움직임만큼 더해줌
                cur_idx += size;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
