package BOj_2056;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] time = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < count; j++){
                max = Math.max(time[Integer.parseInt(st.nextToken()) - 1], max);
            }
            if(max != Integer.MIN_VALUE){
                time[i] += max;
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, time[i]);
        }
        System.out.println(ans);
    }
}
