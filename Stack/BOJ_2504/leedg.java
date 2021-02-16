package SSAFY_Algorithm.Stack.BOJ_2504;

import java.io.*;
import java.util.Stack;

public class leedg {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<String> S = new Stack<>();
        String input = br.readLine();
        boolean flag = true;

        loop:
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int tmp = 0;

            switch(ch) {
                //여는 괄호 들어오면 그냥 넣어줌
                case '(':
                    S.push(ch + "");
                    break;
                //닫는 괄호인 경우에는
                case ')':
                    //비어있거나 대괄호가 앞에 있는 경우에는 올바르지 않은 경우
                    if(S.isEmpty() || (S.peek().charAt(0) == '[')) {
                        flag = false;
                        break loop;
                    //비어있지 않고 괄호의 매칭이 이루어지는 경우에는
                    } else if (!S.isEmpty() && S.peek().charAt(0) == '(') {
                        S.pop();
                        tmp = 2;
                        //괄호 안에 다른 숫자가 존재하는 경우에는 그 숫자를 꺼내와서 더해줌
                        if (!S.isEmpty() && !(S.peek().charAt(0) == '(') && !(S.peek().charAt(0) == '[')) {
                            tmp = Integer.parseInt(S.pop());
                            tmp += 2;
                        }
                        S.push(tmp + "");
                    //그 외의 경우에는 괄호 밖을 탐색 => 곱셈해주는 경우
                    } else {
                        tmp = Integer.parseInt(S.pop());
                        //괄호가 올바르지 않는 경우에는 탈출
                        if(S.isEmpty() || S.peek().charAt(0) != '(') {
                            flag = false;
                            break loop;
                        } else {
                            S.pop();
                            tmp *= 2;
                            //해당 괄호 속에 있는 순자를 2 곱해주고 바깥을 탐색해서 바깥에 있는게 숫자인 경우에는 걔를 더해줌
                            if (!S.isEmpty() && !(S.peek().charAt(0) == '(') && !(S.peek().charAt(0) == '[')) {
                                tmp += Integer.parseInt(S.pop());
                            }
                            S.push(tmp + "");
                        }
                    }
                    break;
                //여는 괄호 들어오면 그냥 넣어줌
                //아래 로직은 소괄호와 동일한 로직임
                case '[':
                    S.push(ch + "");
                    break;
                case ']':
                    if(S.isEmpty() || (S.peek().charAt(0) == '(')) {
                        flag = false;
                        break loop;
                    } else if (!S.isEmpty() && S.peek().charAt(0) == '[') {
                        S.pop();
                        tmp = 3;
                        if (!S.isEmpty() && !(S.peek().charAt(0) == '(') && !(S.peek().charAt(0) == '[')) {
                            tmp = Integer.parseInt(S.pop());
                            tmp += 3;
                        }
                        S.push(tmp + "");
                    } else {
                        tmp = Integer.parseInt(S.pop());
                        if(S.isEmpty() || S.peek().charAt(0) != '[') {
                            flag = false;
                            break loop;
                        } else {
                            S.pop();
                            tmp *= 3;
                            if (!S.isEmpty() && !(S.peek().charAt(0) == '(') && !(S.peek().charAt(0) == '[')) {
                                tmp += Integer.parseInt(S.pop());
                            }
                            S.push(tmp + "");
                        }
                    }
                    break;
            }
        }
        if(S.isEmpty() || S.size() > 1 || S.peek().equals("(") || S.peek().equals(")") || S.peek().equals("]") || S.peek().equals("["))
            flag = false;

        if(!flag) {
            sb.append(0);
        } else {
            sb.append(S.pop());
        }

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}