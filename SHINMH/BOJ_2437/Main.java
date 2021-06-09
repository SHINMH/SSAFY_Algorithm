package BOJ_2437;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        if(array[0] != 1) System.out.println(1);
        else{
            int sum = 1; // array[0] = 1

            for(int i = 1; i < N; i++){
                if(array[i] > sum + 1) break;
                sum += array[i];
            }

            System.out.println(sum + 1);
        }
    }
}
