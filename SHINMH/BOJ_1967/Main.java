package BOJ_1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int child;
        int weight;

        public Node(int child, int weight) {
            this.child = child;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //이진 트리 형태이고,
        //      1
        //     1  1
        //   0  0 1  1
        // 0 0 0 0 1 0 1 1
        //이럻게 되면 형태가 달라짐
        // 가중치가 길이가 됨.
        ArrayList<Node>[] list = new ArrayList[10001];
        for(int i = 0; i < 10001; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int node, child, weight;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            node = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            list[node].add(new Node(child, weight));
        }

    }

    public static int dfs(int node, int w, ArrayList<Node>[] list){
        if(list[node].isEmpty()){
            return w;
        }
        //두 선분의 길이 가져오기
        List<Integer> current = new LinkedList<>();
        int max = 0;
        for(Node ob : list[node]){
            current.add(dfs(ob.child, ob.weight, list));
        }

        return list[node].get(1).weight + max;
    }
}
