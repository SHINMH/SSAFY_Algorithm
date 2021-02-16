package SSAFY_Algorithm.Implementation.BOJ_17827;

import java.io.*;
import java.util.StringTokenizer;

public class leedg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());//노드 개수
        int M = Integer.parseInt(stk.nextToken());//질문 개수
        int V = Integer.parseInt(stk.nextToken());//마지막 노드가 가르키는 노드번호
        int circleLength = N - V + 1;

        String[] tmp = br.readLine().split(" ");

        for(int i = 0; i < M; i++) {
            int move = Integer.parseInt(br.readLine());
            if(move < N) sb.append(tmp[move]).append("\n");
            else {
                move -= (V - 1); // 시작 노드부터 연결 노드까지의 길이를 우선적으로 빼줌
                move %= circleLength; // 뺀 거에서 순환고리의 길이를 나눠줌
                move += (V - 1); // 나머지에다가 뺐던 길이를 다시 더해줌
                sb.append(tmp[move]).append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}

