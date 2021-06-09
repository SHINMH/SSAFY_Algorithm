package BOJ_1493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] array;
    static boolean check;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        array = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        } 
        int answer = fill(length, width, height);
        if(check){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    static int fill(int length, int width, int height){
        if(length == 0 || width == 0 || height == 0) return 0;

        int w = Math.min(length, Math.min(width, height));

        for(int i = N - 1; i >= 0; i--){
            int size = 1 << array[i][0];
            if(size <= w && array[i][1] > 0){
                array[i][1]--;

                return fill(size, size, height - size) + fill(size, width - size, height)
                        + fill(length - size, width, height) + 1;
            }
        }
        check = true;
        return -1;
    }
}
