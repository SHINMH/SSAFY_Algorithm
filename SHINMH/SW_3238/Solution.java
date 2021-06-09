package SW_3238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static long f[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for(int t = 1; t <= TC; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());

            long f[] = new long[(int) (p + 1)];
            f[0] = 1;
            for (int i = 1; i <= p; i++){
                f[i] = (f[i - 1] * i) % p;
            }

            long result = 1;
            while(n > 0 || k > 0){
                long a = n % p;
                long b = n % p;
                if(a < b) result = 0;
                if(result == 0) break;
                result *= f[(int)a];
                result %= k;
                result *= mPow(f[(int) b] * f[(int) (a - b)] % p, p - 2, p);
                result %= k;
                n /= k;
                k /= k;
            }

            System.out.println(result);
        }
    }

    public static long mPow(long a, long k, long p) {
        long result = 1;

        while (k > 0) {
            if (k == 1){
                result *= a;
                result %= p;
            }
            a *= a;
            a %= p;
            k /= 2;
        }

        return result;
    }
}
