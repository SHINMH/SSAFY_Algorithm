package SW_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            List[] vertexs = new ArrayList[101];

            for(int i = 0; i < 101; i++){
                vertexs[i] = new ArrayList<Integer>();
            }

            boolean[] visited = new boolean[101];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                vertexs[from].add(to);
            }

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{start, 0});

            int[] last = new int[2];
            last[0] = Integer.MIN_VALUE; // 마지막 방문 정점 번호
            last[1] = Integer.MIN_VALUE; // 마지막 방문 정점 깊이

            visited[start] = true;
            while(!queue.isEmpty()){
                int[] vertex = queue.poll();
                int depth = vertex[1];
                if(last[1] < depth){
                    last[0] = vertex[0];
                    last[1] = depth;
                }else if(last[1] == depth && last[0] < vertex[0]){
                    last[0] = vertex[0];
                }

                for(int i = 0; i < vertexs[vertex[0]].size(); i++){
                    int next = (int) vertexs[vertex[0]].get(i);
                    if(!visited[next]){
                        queue.add(new int[]{next, depth + 1});
                        visited[next] = true;
                    }
                }
            }
            sb.append("#" + tc + " " + last[0] + "\n");
        }
        System.out.println(sb.toString());
    }
}
