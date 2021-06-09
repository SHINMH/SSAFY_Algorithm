package BOJ_14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] array;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        visited = new boolean[N];
        solution(0, 0);

        System.out.println(answer);
    }

    static void solution(int count, int start){
        if(start == N) return;
        if(count == N/2){
            int[] sum = new int[]{0, 0};
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i] && visited[j]){
                        sum[0] += array[i][j];
                    }
                    if(!visited[i] && !visited[j]){
                        sum[1] += array[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(sum[0] - sum[1]));
            return;
        }

        visited[start] = true;
        solution(count + 1, start + 1);
        visited[start] = false;
        solution(count, start + 1);
    }
}
