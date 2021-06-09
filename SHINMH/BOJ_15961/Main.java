package BOJ_15961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        int[] count = new int[D + 1];
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }


        count[C]++;
        int cnt = 1;
        for(int i = 0; i < K; i++){
            count[array[i]]++;
            if(count[array[i]] == 1) cnt++;
        }

        int max = cnt;
        for(int i = 0; i < N - 1; i++){
            count[array[i]]--;
            if(count[array[i]] == 0) cnt--;
            int next = (i + K) % N;
            count[array[next]]++;
            if(count[array[next]] == 1) cnt++;
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
