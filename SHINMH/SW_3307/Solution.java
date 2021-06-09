package SW_3307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] LIS = new int[N];
            int[] array = new int[N];

            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for(int i = 0; i < N; i++){
                LIS[i] = 1;
                for(int j = 0; j < i; j++){
                    if(array[i] >= array[j] && LIS[i] < LIS[j] + 1){
                        LIS[i] = LIS[j] + 1;
                    }
                    max = Math.max(max, LIS[i]);
                }
            }

            sb.append("#" + tc + " " + max + "\n");
        }
        System.out.println(sb.toString());
    }
}
