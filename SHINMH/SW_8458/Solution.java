package SW_8458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int t = 1; t <= TC; t++){
            int N = Integer.parseInt(br.readLine());
            int[] listX = new int[N];
            int[] listY = new int[N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                listX[i] = Integer.parseInt(st.nextToken());
                listY[i] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
