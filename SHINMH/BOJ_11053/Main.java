package BOJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            LIS[i] = 1;
            for(int j = 0; j < i; j++){
                if(array[j] < array[i] && LIS[i] < LIS[j] + 1){
                    LIS[i] = LIS[j] + 1;
                }
            }
            max = Math.max(max, LIS[i]);
        }

        System.out.println(max);
    }
}
