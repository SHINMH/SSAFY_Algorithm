package BOJ_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            StringTokenizer st;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                array[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
            }

            int min = array[0];
            int count = N;
            for(int i = 1; i < N; i++){
                if(min > array[i]){
                    min = array[i];
                }else{
                    count--;
                }
            }
            System.out.println(count);
        }
    }
}
