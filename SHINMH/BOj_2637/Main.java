package BOj_2637;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] array = new int[N + 1]; // 해당 정점까지 연결된 간선
        int[][] edge = new int[N + 1][N + 1]; // 간선 정보
        int[] countArray = new int[N + 1]; // 완제품 만든데 사용된 부품
        boolean[] basicParts = new boolean[N + 1]; // 기본 부품 표시
        LinkedList<Integer> list = new LinkedList<>();

        Arrays.fill(basicParts, true);
        basicParts[0] = false;
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            edge[from][to] = count;
            array[from]++;
            basicParts[to] = false;
        }
        //자신에게 오는 간선이 없는 부품은 기본 부품이 됨.

        list.add(N); // 완제품 삽입
        countArray[N] = 1;

        while(!list.isEmpty()){
            int current = list.pop();
            for(int i = 1; i <= N; i++){
                if(edge[i][current] != 0){
                    countArray[i] += countArray[current] * edge[i][current];
                    array[i]--;
                    if(array[i] == 0){
                        list.add(i);
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(basicParts[i]){
                System.out.printf("%d %d\n", i, countArray[i]);
            }
        }
    }
}

