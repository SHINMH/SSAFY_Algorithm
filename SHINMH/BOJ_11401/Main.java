package BOJ_11401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long p = 1000000007;
        long f[] = new long[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = (f[i - 1] * i) % p;
        long a = f[n];
        long b = (f[k] * f[n - k]) % p;

        long e = p - 2;
        long bPow = 1;
        while (e > 0) {
            if (e % 2 == 1)
                bPow = (bPow * b) % p;
            b = (b * b) % p;
            e /= 2;
        }

        System.out.println(((a % p) * (bPow % p)) % p);
    }
}
