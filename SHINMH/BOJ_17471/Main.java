package BOJ_17471;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] array;
    static int[][] map;
    static boolean[] checked;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[N][N];
        checked = new boolean[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            for(int j = 0; j < size; j++){
                int indexJ = Integer.parseInt(st.nextToken()) - 1;
                map[i][indexJ] = 1;
            }
        }
        min = Integer.MAX_VALUE;
        solution(0,0);
        System.out.println(min != Integer.MAX_VALUE ? min : -1);
    }

    static boolean isConnect(){
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        // 첫번째 그룹 연결 확인
        for(int i = 0; i < N; i++){
            if(checked[i]){
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0; i < N; i++){
                if(map[current][i] == 1 && !visited[i] && checked[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(checked[i] && !visited[i]){
                return false;
            }
        }
        //두번째 그룹 연결 확인
        Arrays.fill(visited, false);
        queue.clear();

        for(int i = 0; i < N; i++){
            if(!checked[i]){
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0; i < N; i++){
                if(map[current][i] == 1 && !visited[i] && !checked[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(!checked[i] && !visited[i]){
                return false;
            }
        }

        return true;
    }

    static void solution(int count, int start){
        if(count == N) return; // 마지막까지 전부 했을 경우

        for(int i = start; i < N; i++){
            checked[i] = true;
            solution(count + 1, i + 1);
            checked[i] = false;
        }

        if(count == 0) return; // 선거구가 모두 같은 경우

        if(isConnect()){
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i < N; i++){
                if(checked[i]) sum1 += array[i];
                else sum2 += array[i];
            }

            min = Math.min(min, Math.abs(sum1 - sum2));
        }
    }
}
