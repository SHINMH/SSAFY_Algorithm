package BOJ_2281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 줄 숫자
        m = Integer.parseInt(st.nextToken()); // 칸수

        array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(0, 0));
    }

    static int dp(int count, int row){
        if(count == n - 1) return 0;//마지막까지 다 적었을 때, 마지막 줄 적은 곳은 생각 안하므로 무조건 0리턴
        if(row >= m) return dp(count + 1, 0) + ((row == m) ? 0 : 1); // 한줄이 모두 채우거나, 1칸 남았을 때, 무조건 다음 줄에 적어야함.

        // 같은 줄에 적어보기, 마지막까지 그 줄에 적음, 그 줄이 마지막이 되어 길이를 계산하지 않음.
        if(row + array[count] <= m) dp(count + 1, row + 1 + array[count]);
        // 다음 줄에 적어보기 -> 이번 줄에 적히 칸수의 제곱 + 다음줄에 적어보고 남은 칸수 리턴된 값
        int result = dp(count + 1, 0) + (int)Math.pow((m - row), 2);

        return result;
    }
}
