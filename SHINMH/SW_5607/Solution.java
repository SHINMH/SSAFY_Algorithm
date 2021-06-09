package SW_5607;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] d = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();

        int s = 0;
        for(int i = 0; i < n; i++) {
            pq.add(new Info(a[i], i));
            s = i - l;
            while(pq.peek().idx <= s) {
                pq.poll();
            }
            d[i] = pq.peek().n;
        }

        for(int i = 0 ; i < n; i++) {
            sb.append(d[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
    }

    static class Info implements Comparable<Info>{
        int n;
        int idx;
        public Info(int n, int idx) {
            super();
            this.n = n;
            this.idx = idx;
        }
        @Override
        public int compareTo(Info o) {
            return this.n - o.n;
        }
    }

}
