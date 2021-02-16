package SSAFY_Algorithm.LinkedList.BOJ_1406;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class leedg {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> editorList = new LinkedList<>();
        String input = br.readLine();
        int N = input.length();
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            editorList.add(input.charAt(i));
        }
        ListIterator<Character> listIt = editorList.listIterator(N);

        while(M --> 0) {
            input = br.readLine();
            char cmd = input.charAt(0);

            switch(cmd) {
                case 'L':
                    if(listIt.hasPrevious())
                        listIt.previous();
                    break;
                case 'D':
                    if(listIt.hasNext())
                        listIt.next();
                    break;
                case 'B':
                    if(listIt.hasPrevious()) {
                        listIt.previous();
                        listIt.remove();
                    }
                    break;
                case 'P':
                    char ch = input.charAt(2);
                    listIt.add(ch);
                    break;
            }
        }
        for(Character ch : editorList) {
            bw.write(ch);
        }
        bw.flush();
    }
}
