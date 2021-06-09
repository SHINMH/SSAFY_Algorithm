package BOJ_1747;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] array = new boolean[2000000];

        array[1] = true;
        for(int i = 2; i < 2000000; i++){
            if(!array[i]){
                int j = 2;
                while(i * j < 2000000){
                    array[i * j] = true;
                    j++;
                }
            }
        }

        for(int i = N; i < 2000000; i++){
            if(!array[i]){
                String str = Integer.toString(i);
                boolean flag = true;
                int size = str.length();
                for(int j = 0; j < size/2; j++){
                    if(str.charAt(j) != str.charAt(size - 1 - j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
