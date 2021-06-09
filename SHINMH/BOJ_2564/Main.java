package BOJ_2564;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken()); // 넓이
        int H = Integer.parseInt(st.nextToken()); // 높이

        int N = Integer.parseInt(br.readLine()); // 상점 개수

        int[][] array = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] office = new int[2];

        st = new StringTokenizer(br.readLine(), " ");
        office[0] = Integer.parseInt(st.nextToken());
        office[1] = Integer.parseInt(st.nextToken());

        int[][] direction = new int[5][5];
        direction[1] = new int[]{0, 1, 2, 4 ,3};
        direction[2] = new int[]{0, 2, 1, 3, 4};
        direction[3] = new int[]{0, 3, 4, 1, 2};
        direction[4] = new int[]{0, 4, 3, 2, 1};

        int result = 0;
        for(int i = 0; i < N; i++){
            int distance = 0;
            if(office[0] == 1){
                if(array[i][0] == 1){
                    distance = Math.abs(office[1] - array[i][1]);
                } else if(array[i][0] == 2){
                    distance = Math.min(office[1] + array[i][1], (W - office[1]) + (W - array[i][1])) + H;
                } else if(array[i][0] == 3){
                    distance = Math.abs(office[1] + array[i][1]);
                } else if(array[i][0] == 4){
                    distance = Math.abs((W - office[1]) + array[i][1]);
                }
            }else if(office[0] == 2){
                if(array[i][0] == 1){
                    distance = Math.min(office[1] + array[i][1], (W - office[1]) + (W - array[i][1])) + H;
                } else if(array[i][0] == 2){
                    distance = Math.abs(office[1] - array[i][1]);
                } else if(array[i][0] == 3){
                    distance = Math.abs(office[1] + (H - array[i][1]));
                } else if(array[i][0] == 4){
                    distance = Math.abs((W - office[1]) + (H - array[i][1]));
                }
            } else if(office[0] == 3){
                if(array[i][0] == 1){
                    distance = office[1] + array[i][1];
                } else if(array[i][0] == 2){
                    distance = H - office[1] + array[i][1];
                } else if(array[i][0] == 3){
                    distance = Math.abs(office[1] - array[i][1]);
                } else if(array[i][0] == 4){
                    distance = Math.min(office[1] + array[i][1], (H - office[1]) + (H - array[i][1])) + W;
                }
            } else if(office[0] == 4){
                if(array[i][0] == 1){
                    distance = W - array[i][1] + office[1];
                } else if(array[i][0] == 2){
                    distance = W - array[i][1] + H - office[1];
                } else if(array[i][0] == 3){
                    distance = Math.min(office[1] + array[i][1], (H - office[1]) + (H - array[i][1])) + W;
                } else if(array[i][0] == 4){
                    distance = Math.abs(office[1] - array[i][1]);
                }
            }
            result += distance;
        }
        System.out.println(result);
    }
}
