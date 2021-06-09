package BOJ_20055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> container = new LinkedList<>();
        boolean[] item = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N * 2; i++){
            container.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 1;
        while(true){
            rotate(container, item); // 한칸 회전
            move(container, item);
            if(check(container) >= K){
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }

    // 컨테이너벨트 회전
    public static void rotate(LinkedList<Integer> container, boolean[] item){
        Integer num = container.pollLast();
        container.addFirst(num);

        for(int i = N - 1; i > 0; i--){
            item[i] = item[i - 1];
        }
        item[0] = false;
    }

    public static void move(LinkedList<Integer> container, boolean[] item){
        for(int i = N - 1; i >= 0; i--){
            if(i < N - 1 && item[i] && !item[i + 1] && container.get(i + 1) > 0){
                item[i] = false;
                item[i + 1] = true;
                container.set(i + 1, container.get(i + 1) - 1);
            }

            if(item[N - 1]) item[N - 1] = false;
        }

        if(!item[0] && container.get(0) > 0){
            item[0] = true;
            container.set(0, container.get(0) - 1);
        }
    }

    public static int check(LinkedList<Integer> container){
        int result = 0;
        for(int i = 0; i < N * 2; i++){
            if(container.get(i) == 0) result++;
        }
        return result;
    }
}
