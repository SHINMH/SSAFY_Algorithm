package BOJ_16236;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_test {
    static int N, M, r, c, size, time;
    static int[][] area;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N= Integer.parseInt(br.readLine());
        area= new int[N][N];
        r=0; c=0;
        M= 0;
        size= 2;

        for (int n=0; n<N; n++) {
            st= new StringTokenizer(br.readLine()," ");
            for (int m=0; m<N; m++) {
                area[n][m]= Integer.parseInt(st.nextToken());
                if (area[n][m]>0) {
                    if (area[n][m]==9) {
                        r=n;
                        c=m;
                        area[n][m]= 0;
                    }
                    else
                        M++;
                }
            }
        }
        time= 0;
        if (M>0)
            move();

        bw.write(String.valueOf(time));
        br.close();
        bw.close();

    }

    private static void move() {

        PriorityQueue<Pos> queue= new PriorityQueue<>();
        boolean[][] visited= new boolean[N][N];

        int[] dr= {-1, 0, 0, 1};   // 상 좌 우 하
        int[] dc= {0, -1, 1, 0};

        int cnt= 0;

        queue.offer(new Pos(r,c));
        visited[r][c]= true;

        while (!queue.isEmpty() && M>0) {

            time++;

            int qsize= queue.size();
            for (int s=0; s<qsize; s++) {

                Pos cur= queue.poll();

                for (int i=0; i<dr.length; i++) {
                    int nr= cur.r+dr[i];
                    int nc= cur.c+dc[i];

                    if (nr>=0 && nr<N && nc>=0 && nc<N && area[nr][nc]<=size && !visited[nr][nc]) {
                        queue.offer(new Pos(nr,nc));
                        visited[nr][nc]= true;
                    }
                }

            }

            qsize= queue.size();
            for (int s=0; s<qsize; s++) {

                Pos cur= queue.poll();

                if (area[cur.r][cur.c]>0 && area[cur.r][cur.c]<size) {
                    area[cur.r][cur.c]=0;
                    cnt++;
                    M--;
                    queue.clear();
                    queue.offer(new Pos(cur.r,cur.c));
                    visited= new boolean[N][N];
                    visited[cur.r][cur.c]=true;
                    if (cnt==size) {
                        size++;
                        cnt= 0;
                        break;
                    }
                }

                queue.offer(cur);

            }

        }

    }

    private static class Pos implements Comparable<Pos> {

        int r;
        int c;

        public Pos(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.r==o.r)
                return this.c-o.c;
            else
                return this.r-o.r;
        }

    }
}
