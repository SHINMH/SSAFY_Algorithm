package SSAFY_Algorithm.Tree.BOJ_4256;

import java.io.*;
import java.util.StringTokenizer;

public class leedg {
    private static int[] pre;
    private static int[] in;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TestCase = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        while(TestCase --> 0) {
            int N = Integer.parseInt(br.readLine());

            pre = new int[N];
            in = new int[N];

            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                pre[i] = Integer.parseInt(stk.nextToken());
            }

            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                in[i] = Integer.parseInt(stk.nextToken());
            }
            post(0, N, 0);
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
    private static void post(int start, int end, int root) {
        for(int i = start; i < end; i++) {
            if(pre[root] == in[i]) {
                post(start, i, root + 1);
                post(i + 1, end, root + i - start + 1);
                sb.append(in[i]).append(" ");
            }
        }
    }
}
