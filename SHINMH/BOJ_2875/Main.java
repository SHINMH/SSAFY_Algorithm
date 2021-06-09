package BOJ_2875;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 여
        int M = Integer.parseInt(st.nextToken()); // 남
        int K = Integer.parseInt(st.nextToken()); // 인턴쉽 필수 참여

        int team = Math.min((N / 2), M); // N / M -> 만들 수 있는 팀수
        N -= team * 2;
        M -= team;
        if(N + M >= K){
            System.out.println(team);
        }else{
            System.out.println(team + (int)(Math.floor((double)(N + M - K)/3)));
        }
    }
}
