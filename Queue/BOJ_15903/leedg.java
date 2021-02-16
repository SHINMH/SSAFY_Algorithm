package SSAFY_Algorithm.Queue.BOJ_15903;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Logic
//우선순위큐를 이용해서 풀면 되는 문제
//맨 앞에 있는 가장 작은 숫자 두개를 가지고 더해서 그 값을 두번 큐에 더해주면 됨

public class leedg {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        PriorityQueue<Long> Q = new PriorityQueue<>();

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        while(stk.hasMoreTokens()) {
            Q.add(Long.parseLong(stk.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            long val1 = Q.poll();
            long val2 = Q.poll();
            long sum = val1 + val2;

            Q.add(sum);
            Q.add(sum);
        }

        long answer = 0;

        for(int i = 0; i < N; i++) {
            answer += Q.poll();
        }
        sb.append(answer);
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}

