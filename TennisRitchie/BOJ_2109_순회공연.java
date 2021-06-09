package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
public class BOJ_2109_순회공연 {
	private static class Seminar implements Comparable<Seminar> {
		private int cost, date;
		public Seminar(int cost, int date) {
			super();
			this.cost = cost;
			this.date = date;
		}
		@Override
		public int compareTo(Seminar o) { // date -> cost 순으로 정렬
			if (this.date == o.date) 
				return o.cost - this.cost;
			return this.date - o.date;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = null;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001]; // 강연 스케줄 저장
		PriorityQueue<Seminar> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			pq.offer(new Seminar(Integer.parseInt(input[0]), Integer.parseInt(input[1]))); // pq에 강연 정보 삽입
		}
		int ans = 0; // 최종 비용
		Seminar seminar = new Seminar(0, 0);
		while (!pq.isEmpty()) {
			seminar = pq.poll(); 
			if (arr[seminar.date] == 0) // 뽑아낸 강연의 날짜가 비어있다면 arr[날짜]에 강연 비용을 넣어줌
 				arr[seminar.date] = seminar.cost;
			else { // 뽑아낸 강연의 날짜에 이미 강연이 배정되어 있다면
				Seminar min = new Seminar(10001, 1); 
				for (int i = 1; i < seminar.date; i++) { // 뽑아낸 강연 날짜보다 적은 날 중 비용이 가장 작은 강연을 탐색
					if (min.cost > arr[i]) min = new Seminar(arr[i], i);
					if (min.cost == 0) break;
				}
				// 찾아낸 최소 비용을 갖는 강연이 뽑아낸 강연 비용보다 작을 경우 뽑아낸 강연을 최소 비용 강연 자리에 넣어준다.
				if (min.cost < seminar.cost) arr[min.date] = seminar.cost;
			}
		}
		// 마지막에 출력된 강연의 날짜를 최대값으로 확신할 수 있으므로
		// 현재 arr에 배정된 강연들의 비용을 전부 더해주면 강사가 최대로 얻을 수 있는 수입이 나오고 수입을 출력해준다
		for (int i = 1; i <= seminar.date; i++) ans += arr[i];
		System.out.println(ans);
	}
}
