package BOJ_2812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] array = br.readLine().toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && stack.peekLast() < array[i] && K > 0){
                stack.removeLast();
                K--;
            }
            stack.add(array[i]);
        }
        while(K > 0){
            stack.removeLast();
            K--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.removeFirst());
        }
        bw.write(sb.toString());
        bw.close();
    }
}
