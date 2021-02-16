package SSAFY_Algorithm.Queue.BOJ_17225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Worker { // 직원의 정보를 담는 클래스
	int time = 0; // 1개 선물 포장 소요 시간
	int totalNum = 0; // 포장한 선물 총 개수
	ArrayList<Integer> tasks = new ArrayList<>(); // 선물을 포장해야하는 시간
	LinkedList<Integer> getNum = new LinkedList<>(); // 포장한 선물들의 번호
}

public class leejh {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		Worker Sangmin = new Worker();
		Worker Jisu = new Worker();

		st = new StringTokenizer(br.readLine());
		Sangmin.time = Integer.parseInt(st.nextToken()); // 상민이의 포장 소요 시간
		Jisu.time = Integer.parseInt(st.nextToken()); // 지수의 포장 소요 시간
		
		int N = Integer.parseInt(st.nextToken()); // 손님 수
		int giftNum = 1; // 현재 선물 번호
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken()); // 주문 시각
			char color = st.nextToken().charAt(0); // 선물 색
			int num = Integer.parseInt(st.nextToken()); // 주문한 선물 개수

			if (color == 'B') { // 상민이가 포장할 선물
				for (int j = 0; j < num; j++) // num개의 선물을 포장하는 시각들을 task에 저장
					Sangmin.tasks.add(time + Sangmin.time * j);
				Sangmin.totalNum += num; // 상민이의 포장 횟수 증가
			} else {// 지수가 포장할 선물
				for (int j = 0; j < num; j++)// num개의 선물을 포장하는 시각들을 task에 저장
					Jisu.tasks.add(time + Jisu.time * j);
				Jisu.totalNum += num;// 지수의 포장 횟수 증가
			}
		}
		for (int i = 0, j = 0; i < Sangmin.totalNum || j < Jisu.totalNum;) {
			if (i >= Sangmin.totalNum) { // 상민이의 남은 작업이 없다면 지수의 작업에 선물 번호를 붙여 넣어줌
				Jisu.getNum.add(giftNum++);
				j++;
			} else if (j >= Jisu.totalNum) {// 지수의 남은 작업이 없다면 상민의 작업에 선물 번호를 붙여 넣어줌
				Sangmin.getNum.add(giftNum++);
				i++;
			} else { // 상민과 지수 둘 다 남아있는 작업이 있다면
				if (Sangmin.tasks.get(i) <= Jisu.tasks.get(j)) { // 지수&상민의 각 맨 앞의 작업시간 중 상민이의 작업 시간이 지수보다 빠르거나 같으면 상민이에게 작업을 할당 
					Sangmin.getNum.add(giftNum++);
					i++;
				} else { // 지수가 상민이보다 선물 포장 시작 시간이 빠를 때 선물 번호 붙여 포장한 선물을 담는 배열에 넣음
					Jisu.getNum.add(giftNum++);
					j++;
				}
			}
		}
		bw.write(Sangmin.totalNum + "\n");
		for (int i : Sangmin.getNum)
			bw.write(i + " ");
		bw.write("\n" + Jisu.totalNum + "\n");
		for (int i : Jisu.getNum)
			bw.write(i + " ");
		bw.write("\n");
		bw.flush();
	}
}
