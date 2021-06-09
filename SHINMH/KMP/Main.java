package KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int tLength = text.length;
        int pLength = pattern.length;

        //패턴 매칭 실패함수 (자신이랑 일치하는 구간을 찾는 함수)
        int[] fail = new int[pLength];
        for(int i = 1, j = 0; i < pLength; i++){
            while(j > 0 && pattern[i] != pattern[j]){
                j = fail[j - 1];
            }
            if(pattern[i] == pattern[j]) fail[i] = ++j;
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0, j = 0; i < tLength; i++){
            while(j > 0 && text[i] != pattern[j]){ // j위치랑 i위치가 일치하지 않는다면, 패턴함수를 통해서 일치구간을 찾음
                j = fail[j - 1];
            }

            if(text[i] == pattern[j]){ // i위치랑 j위치가 일치할때
                if(j == pLength - 1){ // 마지막에 도달시, 마지막에 도달해도 자신의 위치에서 다른 글자를 또 찾을 수 있음, 예를 들어) abababa, aba 인경우 2번 인덱스까지하면 일치하지만, 4번에서도 일치함.
                    cnt++;
                    list.add((i + 1) - pLength + 1);
                    j = fail[j];
                }else{
                    j++;
                }
            }
        }

        if(cnt>0) {
            System.out.println(list);
        }
    }
}
