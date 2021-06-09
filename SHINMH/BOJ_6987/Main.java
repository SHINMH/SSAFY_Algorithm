package BOJ_6987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] array;
    static int N;
    static boolean answer;

    static int[] team1= {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] team2= {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        array = new int[6][3];
        N = 6;
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < 4; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = false;
            solution(0);
            sb.append(answer ? "1 ": "0 ");
        }
        System.out.println(sb.toString());
    }

    static void solution(int current){
        if(answer) return;
        if(current == 15){
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    if(array[i][j] != 0) return;
                }
            }
            answer = true;
            return;
        }

        int home = team1[current];
        int away = team2[current];

        //win
        array[home][0]--;
        array[away][2]--;
        solution(current + 1);
        array[home][0]++;
        array[away][2]++;

        //draw
        array[home][1]--;
        array[away][1]--;
        solution(current + 1);
        array[home][1]++;
        array[away][1]++;

        //lose
        array[home][2]--;
        array[away][0]--;
        solution(current + 1);
        array[home][2]++;
        array[away][0]++;
    }
}
