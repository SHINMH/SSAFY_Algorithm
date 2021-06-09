package BOJ_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N + 1];

        if(N == 1){
            System.out.println(0);
        }
        else{
            array[1] = 0;

            for(int i = 2; i < N + 1; i++){
                array[i] = array[i-1] + 1;
                if(i % 2 == 0){
                    array[i] = Math.min(array[i], array[i/2] + 1);
                }
                if(i % 3 == 0){
                    array[i] = Math.min(array[i], array[i/3] + 1);
                }
            }

            System.out.println(array[N]);
        }
    }
}
