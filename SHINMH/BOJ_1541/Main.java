package BOJ_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = 0; 
        int size = str.length();

        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> operStack = new Stack<>();

        while(index < size){
            if(str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                int num = 0;
                while(index < size && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                    num *= 10;
                    num += str.charAt(index) - '0';
                    index++;
                }
                numStack.add(num);
            }
            if(index >= size) break;
            if(str.charAt(index) == '+'){
                operStack.add(1);
            }else if(str.charAt(index) == '-'){
                operStack.add(2);
            }
            index++;
        }

        int sum = 0;
        while(!operStack.isEmpty()){
            int oper = operStack.pop();
            if(oper == 1){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                numStack.add(num1 + num2);
            }
            else if (oper == 2){
                sum -= numStack.pop();
            }
        }
        if (!numStack.isEmpty()) sum += numStack.pop();

        System.out.println(sum);
    }
}
