package SW_1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= TC; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] array = new int[N][2];
            boolean[] visited = new boolean[N];
            long[] minEdge = new long[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                array[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                array[i][1] = Integer.parseInt(st.nextToken());
                minEdge[i] = Long.MAX_VALUE;
            }

            double E = Double.parseDouble(br.readLine());

            long result = 0;
            minEdge[0] = 0;

            for(int c = 0; c < N; c++){
                long min = Long.MAX_VALUE;
                int minVertex = 0;

                for(int i = 0; i < N; i++){
                    if(!visited[i] && min > minEdge[i]){
                        min = minEdge[i];
                        minVertex = i;
                    }
                }

                result += min;
                visited[minVertex] = true;

                for(int i = 0; i < N; i++){
                    long distance = (long) (Math.pow(Math.abs(array[minVertex][0] - array[i][0]), 2) +  Math.pow(Math.abs(array[minVertex][1] - array[i][1]), 2));
                    if(!visited[i] && minEdge[i] > distance){
                        minEdge[i] = distance;
                    }
                }
            }
            sb.append("#" + tc + " " + Math.round(result * E) + "\n");
        }
        System.out.println(sb.toString());
    }
}
