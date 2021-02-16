package SSAFY_Algorithm.Queue.BOJ_17225;
import java.io.*;
import java.util.*;

//Logic
//각 상품 종류별로 큐를 만들어서 상품을 저장해 놓는다
//상민이가 지민이보다 짬이 더 높기때문에 상민이에게 포장을 받아야하는 상품들의 큐의 peek를 먼저 검증
//검증하여서 지민이 큐보다 시간이 빠른 상품이 존재하면 해당 조건에 맞는 상품큐를 가지고 로직을 돌려준다

//문제해결 로직 내에서는 해당 알바생의 큐에 대기 중인 상품의 remain을 1 감소시켜주고
//해당 상품의 시간은 update해주고 만약 remain이 0이면은 제거하고 업데이트 된 시간을 그 다음 상품에 적용해줌

public class leedg {
    private static class PresentInfo {
        int inputTime;
        int remain;
        public PresentInfo(int input, int remain) {
            this.inputTime = input;
            this.remain = remain;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //상민, 지민이 큐
        Queue<PresentInfo> sangminQueue = new LinkedList<>();
        Queue<PresentInfo> jiminQueue = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());

        //상민이, 지민이 전용 StringBuilder
        StringBuilder sangminSb = new StringBuilder();
        StringBuilder jiminSb = new StringBuilder();


        int sangminCnt = 0;
        int jiminCnt = 0;

        //상민이, 지민이가 각각 포장하는데 걸리는 시간
        int sangminTime = Integer.parseInt(stk.nextToken());
        int jiminTime = Integer.parseInt(stk.nextToken());

        //고객 숫자
        int customNum = Integer.parseInt(stk.nextToken());

        //포장한 총 상품 개수
        int prdNum = 1;

        //정보 입력 받기
        for(int i = 0; i < customNum; i++) {
            stk = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(stk.nextToken());
            char ch = stk.nextToken().charAt(0);
            int remain = Integer.parseInt(stk.nextToken());

            if(ch == 'B') {
                sangminQueue.offer(new PresentInfo(input, remain));
            } else {
                jiminQueue.offer(new PresentInfo(input, remain));
            }
        }

        //상민이, 지민이 큐 둘 중 하나가 빌때까지 logic 수행
        while(!sangminQueue.isEmpty() || !jiminQueue.isEmpty()) {

            //상민이큐가 비어있지 않고 상민이 큐의 맨 앞에 대기중인 상품의 업데이트 된 시간이
            //지민이꺼보다 빠르면은 상민이꺼를 가져옴
            if(!sangminQueue.isEmpty() && (jiminQueue.isEmpty() || sangminQueue.peek().inputTime <= jiminQueue.peek().inputTime)) {
                logic(sangminQueue, sangminSb, sangminTime, prdNum++);
                sangminCnt++;
            } else {
                //그 외의 경우에는 지민이꺼를 해줌
                logic(jiminQueue, jiminSb, jiminTime, prdNum++);
                jiminCnt++;
            }
        }

        sangminSb.delete(sangminSb.length() - 1, sangminSb.length());
        jiminSb.delete(jiminSb.length() - 1, jiminSb.length());
        sb.append(sangminCnt).append("\n").append(sangminSb).append("\n").append(jiminCnt).append("\n").append(jiminSb);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void logic(Queue<PresentInfo> Q, StringBuilder sb, int time, int num) {
        sb.append(num).append(" ");
        int t = Q.peek().inputTime + time;
        if(--Q.peek().remain == 0) Q.poll();
        //큐에서 뽑아버리고 난 이후일 수 있으니까
        //맨 앞에 대기중에 상품의 시간 정보를 업데이트 해줌
        if(!Q.isEmpty()) Q.peek().inputTime = Math.max(Q.peek().inputTime, t);
    }
}

