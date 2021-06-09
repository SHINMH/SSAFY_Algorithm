package BOJ_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] array = new int[101][2];
        for(int i = 0; i < N + M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            array[Integer.parseInt(st.nextToken())][0] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int index = queue.poll();
            if(index == 100){
                System.out.println(array[index][1]);
                break;
            }

            for(int i = 1; i <= 6; i++){
                int nIndex = index + i;

                if(nIndex >= 101) continue;

                if(array[nIndex][0] != 0){
                    nIndex = array[nIndex][0];
                }
                if(array[nIndex][1] == 0){
                    array[nIndex][1] = array[index][1] + 1;
                    queue.add(nIndex);
                }
            }
        }
    }
}
