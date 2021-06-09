package BOJ_2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        int[] drink = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        drink[1] = array[1];
        if(N >= 2) drink[2] = array[1] + array[2];

        //3가지 경우로 나눌 수 있음, i번째를 안먹거나, i-1을 안먹거나, i-1, i 연달아 먹거나
        for(int i = 3; i <= N; i++){
            drink[i] = Math.max(drink[i - 1], Math.max(drink[i - 2] + array[i], drink[i - 3] + array[i - 1] + array[i]));
        }

        System.out.println(drink[N]);
    }
}
