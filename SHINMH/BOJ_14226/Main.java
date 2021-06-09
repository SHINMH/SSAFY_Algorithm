package BOJ_14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Emoticon {
        int draw;
        int clipboard;

        public Emoticon(int draw, int clipboard) {
            this.draw = draw;
            this.clipboard = clipboard;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        int[][] array = new int[S + 1][S + 1]; // 화면에 있는 이모티콘, 클립보드에 있는 이모티콘
        Queue<Emoticon> queue = new LinkedList<>();
        queue.add(new Emoticon(1, 0));

        while(!queue.isEmpty()){
            Emoticon emoticon = queue.poll();

            if(emoticon.draw == S){
                System.out.println(array[emoticon.draw][emoticon.clipboard]);
                break;
            }

            //0: 클립보드 복사, 1: 클립보드 붙여넣기, 2: 이모티콘하나 뺴기
            int[] draw = {emoticon.draw, emoticon.draw + emoticon.clipboard, emoticon.draw - 1};
            int[] clip = {emoticon.draw, emoticon.clipboard, emoticon.clipboard};

            for(int i = 0; i < 3; i++){
                if(draw[i] < 0 || clip[i] < 0 || draw[i] >= S + 1 || clip[i] >= S + 1) continue;
                if(array[draw[i]][clip[i]] != 0) continue;
                queue.add(new Emoticon(draw[i], clip[i]));
                array[draw[i]][clip[i]] = array[emoticon.draw][emoticon.clipboard] + 1;
            }
        }
    }
}
