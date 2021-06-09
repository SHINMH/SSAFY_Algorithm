package BOj_5052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            String[] array = new String[N];
            for(int j = 0; j < N; j++){
                array[j] = br.readLine();
            }

            Arrays.sort(array);

            boolean answer = true;
            for(int j = 0; j < N - 1; j++){
                if(array[j+1].startsWith(array[j])) {
                    answer = false;
                    break;
                }
            }
            System.out.println(answer? "YES":"NO");
        }
    }
}
