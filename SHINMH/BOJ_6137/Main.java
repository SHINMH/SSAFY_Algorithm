package BOJ_6137;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[] array;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        array = new char[N];

        for(int i = 0; i < N; i++){
            array[i] = br.readLine().charAt(0);
        }

        int left = 0, right = array.length - 1;
        for(int i = 0; i < N; i++){
            if(i != 0 && i % 80 == 0){
                answer.append("\n");
            }
            if(array[left] < array[right]){
                answer.append(array[left]);
                left++;
            }else if(array[left] > array[right]){
                answer.append(array[right]);
                right--;
            }else{
                if(compare(left, right)){
                    answer.append(array[right]);
                    right--;
                }else{
                    answer.append(array[left]);
                    left++;
                }
            }
        }

        System.out.println(answer.toString());
    }

    public static boolean compare(int left, int right){
        while(left < right && array[left] == array[right]){
            left++;
            right--;
        }

        return array[left] - array[right] > 0 ? true : false;
    }
}
