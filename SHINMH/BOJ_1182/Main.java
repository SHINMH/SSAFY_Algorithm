package BOJ_1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        solution(0, array, 0, N, S);
        System.out.println(answer);
    }
/*
    public static void solution(int count,int[] array, int sum, int N, int S, int select){
        if(count == N){
            if(sum == S && select > 0){
                answer++;
            }
            return;
        }
        solution(count + 1, array, sum + array[count], N, S, select + 1);
        solution(count + 1, array, sum, N, S, select);
    }
*/
    public static void solution(int start,int[] array, int sum, int N, int S){
        if(sum == S && start > 0){
            answer++;
        }
        if(start == N) return;
        for(int i = start; i < N; i++){
            solution(i + 1, array, sum + array[i], N, S);
        }
    }
}
