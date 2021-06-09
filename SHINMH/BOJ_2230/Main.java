package BOJ_2230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int min = Integer.MAX_VALUE;
        int right = 0, left = 0;
        while(right < N){
            if(array[right] - array[left] < M){
                right++;
            }else{
                min = Math.min(min, array[right] - array[left]);
                if(min == M) break;
                left++;
            }
        }

        System.out.println(min);
    }
}
