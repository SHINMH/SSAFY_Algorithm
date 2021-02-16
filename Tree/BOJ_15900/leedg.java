package SSAFY_Algorithm.Tree.BOJ_15900;

import java.io.*;
import java.util.*;

public class leedg {
    static LinkedList<Integer>[] infoList;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());
        infoList = new LinkedList[N + 1];

        for(int i = 1; i <= N; i++) {
            infoList[i] = new LinkedList<>();
        }
        for(int i = 0; i < N-1; i++) {
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            infoList[A].add(B);
            infoList[B].add(A);
        }

        DFS(1, 0, 0);

        if(answer % 2 == 0) sb.append("No").append("\n");
        else sb.append("Yes").append("\n");

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
    private static void DFS(int curNode, int prevNode, int depth) {
        if(infoList[curNode].size() == 1 && prevNode == infoList[curNode].get(0)) {
            answer += depth;
        }

        for(int nextNode : infoList[curNode]) {
            if(nextNode != prevNode) {
                DFS(nextNode, curNode, depth + 1);
            }
        }
    }
}