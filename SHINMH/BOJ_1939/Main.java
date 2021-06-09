package BOJ_1939;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] node;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 섬의 수
        M = Integer.parseInt(st.nextToken()); // 다리의 수

        node = new int[N + 1];

        ArrayList<int[]> list = new ArrayList<>();
        int start, end, weight;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            list.add(new int[]{start, end, weight});
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(kruscal(list, start, end));
    }

    public static int kruscal(ArrayList<int[]> list, int start, int end){
        int answer = 0;
        for(int i = 0; i < N + 1; i++){
            node[i] = i;
        }
        //중량 순으로 정렬
        list.sort((o1, o2) -> o2[2] - o1[2]);

        for(int[] current : list){
            merge(current[0], current[1]);

            if(find(start) == find(end)){
                answer = current[2];
                break;
            }
        }
        return answer;
    }

    public static int find(int u){
        if(node[u] == u) return u;
        return node[u] = find(node[u]);
    }

    public static void merge(int v, int u){
        int parentU = find(u);
        int parentV = find(v);

        if(parentU == parentV) return;

        node[parentU] = parentV;
    }
}
