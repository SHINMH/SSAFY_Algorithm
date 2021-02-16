package com.study2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 카드 합체 놀이 

// 자연수 카드 n 장  - i번 카드에 ai 쓰여있음. 
// 과정 ) x번 카드와 y번 카드를 골라 그 두장에 쓰여진 수를 더한 값을 계산 
//		) 계산한 값을 x번 카드와 y번 카드 두장에 모두 덮어 쓴다. 
// m번 하면 놀이 끝. - n장에 카드에 쓰여있는 수를 모두 더한 값이 점수 
// 점수의 최솟값 구해라 

// 1. 카드 중 제일 작은 2개 선택하기 
// 2. 2개 더한 값을 2개에 덮어쓰기
// 3. 카드 다 더하기 

public class BOJ_15903_카드합체놀이 {

	static int n, m;
	static int[] arr;
	static int min, min2, sum, sum2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> pq = new PriorityQueue<Integer>();

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 카드의 개수
		m = Integer.parseInt(st.nextToken()); // 카드 합체하는 횟수

		arr = new int[n];

		// 카드의 처음 상태
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.offer(arr[i]);
		}

		// 제일 작은 거 두개 구하기
		for (int i = 0; i < m; i++) {
			// 제일 작은 거
			min = pq.poll();

			// 그 자음 작은 거
			min2 = pq.poll();

			sum = min + min2;

			// 더한값으로 덮어주기
			pq.offer(sum);
			pq.offer(sum);

		}

		// 덮은 pq 총합 구하기
		for (int j = 0; j < n; j++) {
			sum2 += pq.poll();
		}

		System.out.println(sum2);

	}

}
