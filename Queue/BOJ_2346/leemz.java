
package SSAFY_Algorithm.Queue.BOJ_2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 풍선터트리기 

// n개의 풍선 ( -n ~ n )
// 1번 풍선 터트림 -> 풍선 안 종이 값 이동해 풍선 터트림 ( 양수 - 오른쪽, 음수 - 왼쪽 )
// 원형으로 놓여있음 시계방향 .. 
// 이동할 때 이미 터진 풍선은 빼고 생각 

// linkedlist 문제임 양쪽으로 움직일 수 있어야됨 .. 
// 검색 = arrayList 빠름 / 추가, 삭제 = LinkedList 빠름 
public class leemz {

	static int n;
	static int point;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		LinkedList<Node> list = new LinkedList<Node>();

		n = Integer.parseInt(br.readLine()); // 풍선 개수

		point = 0;
		cnt = 0;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) { // 순서대로 노드 번호 저장하기 위해서
			list.add(new Node(i, Integer.parseInt(st.nextToken())));
		}

		for (int j = 0; j < n; j++) {
			if (cnt > 0) { // 오른쪽 이동
				for (int i = 0; i < cnt - 1; i++) {
					point++;
					if (point >= list.size()) {
						point = 0;
					}
				}
			} else if (cnt < 0) { // 왼쪽이동인데 -1곱해서 양수
				cnt *= -1;
				for (int i = 0; i < cnt; i++) {
					point--;
					if (point < 0) {
						point = list.size() - 1;
					}
				}
			}

			Node node = list.get(point);
			cnt = node.value;
			System.out.print(node.num + " ");
			list.remove(point);

			if (point == list.size()) {
				point = 0;
			}
		}

//			point = list.get(cnt);
//			list.remove(cnt);
//			System.out.println(cnt+"번 풍선 터짐");
//			cnt+=point;
//			cnt-=1;
//			
//			Math.abs(cnt);
//			
//			System.out.println("point값: "+point);
//			System.out.println("cnt값: "+cnt);
//			System.out.println("list 상황: "+list);

	}

	static class Node {
		int num;
		int value;

		Node(int n, int v) {
			this.num = n;
			this.value = v;
		}
	}
}
