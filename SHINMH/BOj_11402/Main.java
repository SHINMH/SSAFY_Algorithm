package BOj_11402;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[][] array = new long[2001][2001];
        array[0][0] = 1;
        array[1][0] = 1;
        array[1][1] = 1;

        for(int i = 2; i <= 2000; i++){
            array[i][0] = 1;
            array[i][i] = 1;
            for(int j = 1; j < i; j++){
                array[i][j] = (array[i - 1][j] + array[i - 1][j - 1]) % M;
            }
        }

        long answer = 1;
        long nMod, kMod;
        while(N > 0){
            nMod = N % M;
            kMod = K % M;

            answer *= array[(int) nMod][(int) kMod];
            answer %= M;

            N -= nMod;
            K -= kMod;
            N /= M;
            K /= M;
        }

        System.out.println(answer);
    }
}
