package SW_8382;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int t = 1; t <= TC; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int transverse = Math.abs(x1 - x2);
            int length = Math.abs(y1 - y2);

            if(Math.abs(transverse - length) > 1){
                int temp = Math.abs(transverse - length);
                temp = temp % 2 == 0 ? temp : temp - 1;
                System.out.println("#" + t + " " + (transverse + length + temp));
            } else {
                System.out.println("#" + t + " " + (transverse + length));
            }
        }
    }
}
