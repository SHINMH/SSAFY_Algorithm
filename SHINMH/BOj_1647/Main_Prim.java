package BOj_1647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_Prim {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] map = new ArrayList[N];
        for(int i = 0; i < N; i++){
            map[i] = new ArrayList<int[]>();
        }

        int start, end, price;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;
            price = Integer.parseInt(st.nextToken());

            map[start].add(new int[]{end, price});
            map[end].add(new int[]{start, price});
        }

        int[] minEdge = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;

        int result = 0;
        for(int c = 0; c < N - 1; c++){
            int min = Integer.MAX_VALUE;
            int minVertex = 0;
            for(int i = 0; i < N; i++){
                if(!visited[i] && min > minEdge[i]){
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            result += min;
            visited[minVertex] = true;

            for(int[] ob : map[minVertex]){
                if(!visited[ob[0]] && minEdge[ob[0]] > ob[1]){
                    minEdge[ob[0]] = ob[1];
                }
            }
        }
        System.out.println(result);
    }
}
