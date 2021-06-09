package BOJ_20197;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String[] uphone;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        uphone = br.readLine().split(" ");
        int H = Integer.parseInt(br.readLine());
        int width = (int)Math.pow(K, 2);

        int[][] map = new int[width][width];

        makeUphone(0, 0, width, width, 0);
    }

    public static void makeUphone(int y, int x, int sizeY, int sizeX, int index){
        if(index == 2 * K){

            return;
        }

        if(uphone[index].equals("R") ||  uphone[index].equals("L")){
            makeUphone(y, x, sizeY, sizeX/2, index + 1);
            makeUphone(y, sizeX/2 + x, sizeY, sizeX/2, index + 1);
        }else if(uphone[index].equals("U") && uphone[index].equals("D")){
            makeUphone(y, x, sizeY/2, sizeX, index + 1);
            makeUphone(sizeY/2 + y, x, sizeY/2, sizeX, index + 1);
        }
    }
}
