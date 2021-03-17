package SSAFY_Algorithm.Stack.BOJ_1662;
import java.io.*;
import java.util.Stack;

public class leedg {
    private static final long leftBracket = -1;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Long> S = new Stack<>(); //
        String input = br.readLine();

        long length = 0;
        long num = 0, tmp = 0, cnt = 0;
        for(int idx = 0; idx < input.length(); idx++) {
            char ch = input.charAt(idx);

            if(ch == '(') {
                if(length > 1) {
                    length--;
                    S.push(length);
                    S.push(num);
                } else {
                    S.push(num);
                }
                length = 0;
                S.push(leftBracket);
            } else if(ch == ')') {
                tmp = 0;
                while(!S.isEmpty()) {
                    cnt = 0;
                    tmp = S.pop();
                    if(tmp == leftBracket) {
                        cnt = S.pop();
                        length *= cnt;
                        if(!S.isEmpty() && S.peek() > 0) {
                            length += S.pop();
                        }
                        S.push(length);
                        length = 0;
                        break;
                    } else {
                        length += tmp;
                    }
                }
            } else {
                num = ch - '0';
                length++;
                if(ch != ')' && idx == input.length() - 1) {
                    if(S.isEmpty()) {
                        S.push(length);
                    } else {
                        length += S.pop();
                        S.push(length);
                    }
                }
            }
        }

        length = 0;
        while(!S.isEmpty()) {
            length += S.pop();
        }
        bw.write(String.valueOf(length));
        bw.close();
        br.close();
    }
}
