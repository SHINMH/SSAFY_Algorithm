package BOJ_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int i = 0;
        int j = N - 1;
        int minX = 0;
        int minY = 0;
        int min = Integer.MAX_VALUE;
        while(i < j){
            if(min > Math.abs(array[i] + array[j])){
                min = Math.abs(array[i] + array[j]);
                minX = array[i];
                minY = array[j];
            }

            if(array[i] + array[j] < 0){
                i++;
            }else{
                j--;
            }
        }
        System.out.println(minX + " " + minY);
    }
}
