package BOJ_1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Long> list;
    static int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(1022 < N) System.out.println(-1);
        else{
            list = new ArrayList<>();

            for(int i = 1; i <= 10; i++){
                combination(0, 0, i, new int[10]);
            }
            list.sort((num1, num2) -> num1.compareTo(num2));
            System.out.println(list.get(N));
        }
    }

    static void combination(int count, int start, int N, int[] visited){
        if(count == N){
            long num = 0;
            for(int i = 0; i < N; i++) {
                num += visited[i] * Math.pow(10, i);
            }
            list.add(num);
            return;
        }

        for(int i = start; i < 10; i++){
            visited[count] = array[i];
            combination(count + 1, i + 1, N, visited);
        }
    }
}
