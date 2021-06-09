package BOJ_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        for (int i = 0; i <= N; i++) {
            list[i].sort((o1, o2) -> o1 - o2);
        }

        visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.add(V);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if(!visited[current]){
                System.out.print(current + " ");
                visited[current] = true;

                for (int i = list[current].size() - 1; i >= 0; i--) {
                    if (!visited[list[current].get(i)]) {
                        stack.add(list[current].get(i));
                    }
                }
            }
        }
        System.out.println();

        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Integer ob : list[current]) {
                if (!visited[ob]) {
                    queue.add(ob);
                    visited[ob] = true;
                }
            }
        }
        System.out.println();
    }
}
