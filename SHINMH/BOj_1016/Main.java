package BOj_1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] array = new boolean[1000001];

        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;

        System.out.println(min);

        for(int i = 2; i < 1000001; i++){
            if(array[i]){
                int mul = 2;
                while(i * mul < 1000001){
                    array[i * mul] = false;
                    mul++;
                }
            }
        }

        int num = (int)Math.sqrt(3);
        System.out.println(num);
        System.out.println(Math.sqrt(3));


    }
}
