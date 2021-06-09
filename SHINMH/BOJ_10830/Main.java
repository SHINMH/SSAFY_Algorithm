package BOJ_10830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] array = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        array = solution(array, B, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print((array[i][j] % 1000) + " ");
            }
            System.out.println();
        }
    }
    public static int[][] solution(int[][] array, long B,int N){
        if(B == 1) return array;
        int[][] temp = solution(array, B/2, N);
        if(B % 2 == 0) return multipleMatrix(temp, temp, N);
        else return multipleMatrix(array, solution(array, B - 1, N), N);
    }

    public static int[][] multipleMatrix(int[][] arrayA, int[][] arrayB,  int N){
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    result[i][j] += arrayA[i][k] * arrayB[k][j];
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }
}
