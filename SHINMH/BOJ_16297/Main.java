package BOJ_16297;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        int[][] array = new int[N][M];
        answer = Integer.MAX_VALUE;

        int ry = 0, rx = 0, by = 0, bx = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == 'o'){
                    array[i][j] = 0;
                    if(count == 0){
                        ry = i;
                        rx = j;
                        count++;
                    }else{
                        by = i;
                        bx = j;
                    }
                }else if(str.charAt(j) == '#'){
                    array[i][j] = 1;
                }else {
                    array[i][j] = 0;
                }
            }
        }
        dfs(array, rx, ry, bx, by, 0, N, M);

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    static void dfs(int[][] array, int rx, int ry, int bx, int by ,int count, int N, int M){
        if(count >= 10) return;
        if(rx == bx && ry == by) return;
        if(array[ry][rx] == 1 || array[by][bx] == 1) return;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for(int i = 0; i < 4; i++){
            int dropCount = 0;
            int nrx, nry, nbx, nby;
            nrx = rx + dx[i];
            nry = ry + dy[i];
            nbx = bx + dx[i];
            nby = by + dy[i];
            if(nry < 0 || nrx < 0 || nry >= N || nrx >= M) dropCount++;
            if(nby < 0 || nbx < 0 || nby >= N || nbx >= M) dropCount++;

            if(dropCount == 1){
                answer = Math.min(answer, count + 1);
                continue;
            }else if(dropCount == 2){
                continue;
            }

            if(array[nry][nrx] == 1 && array[nby][nbx] == 1) continue;
            if(array[nry][nrx] == 1){
                dfs(array, rx, ry, nbx, nby, count + 1, N, M);
            }else if(array[nby][nbx] == 1){
                dfs(array, nrx, nry, bx, by, count + 1, N, M);
            }else{
                dfs(array, nrx, nry, nbx, nby, count + 1, N, M);
            }
        }
    }
}
