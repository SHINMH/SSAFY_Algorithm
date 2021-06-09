package BOj_5430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int tc = 0; tc < T; tc++){
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();
            StringBuilder str = new StringBuilder(br.readLine());
            StringTokenizer st = new StringTokenizer(str.toString(), ",[]");
            //리스트 생성
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            int rCount = 1;
            for(int i = 0; i < p.length(); i++){
                if(p.charAt(i) == 'D'){
                    N--;
                    if(N < 0){
                        answer.append("error\n");
                        break;
                    }

                    if(rCount > 0){
                        list.removeFirst();
                    }else{
                        list.removeLast();
                    }
                }else{
                    rCount *= -1;
                }
            }

            if(N < 0) continue;

            answer.append("[");
            if(rCount > 0){
                for(int i = 0; i < N; i++){
                    answer.append(list.removeFirst());
                    if(i != N - 1){
                        answer.append(",");
                    }
                }
            }else{
                for(int i = 0; i < N; i++){
                    answer.append(list.removeLast());
                    if(i != N - 1){
                        answer.append(",");
                    }
                }
            }
            answer.append("]\n");
        }
        System.out.println(answer.toString());
    }
}
