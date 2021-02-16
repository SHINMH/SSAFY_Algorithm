package SSAFY_Algorithm.LinkedList.BOJ_1406;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class ParkSeRyeong {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/linkedlist/editor_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<String> list = new LinkedList<>();

		String tmp = br.readLine();
		for (int i = 0; i < tmp.length(); i++) {
			list.add(String.valueOf(tmp.charAt(i)));
		}
		int M = Integer.parseInt(br.readLine());
		int index = list.size();

		ListIterator<String> iter = list.listIterator();

		while (iter.hasNext()) {
			iter.next();
		}

		for (int i = 0; i < M; i++) {
			tmp = br.readLine();
//			System.out.println("**************************************\n");
//			System.out.println("현재 인덱스 : " + index + " / " + list.toString());
//			System.out.println("연산 " + tmp.charAt(0) + "시작");
			if (tmp.length() > 2) {
				// P연산
				iter.add(String.valueOf(tmp.charAt(2)));
			} else {
				// L연산
				if (iter.hasPrevious() && tmp.equals("L"))
					iter.previous();

				// D연산
				else if (iter.hasNext() && tmp.equals("D"))
					iter.next();

				// B연산
				else if (iter.hasPrevious() && tmp.equals("B")) {
					iter.previous();
					iter.remove();
				}
			}
//			System.out.println("--------------------");
//			System.out.println("현재 인덱스 : " + index + " / " + list.toString());
//			System.out.println();
		}
		for (String s : list) {
			bw.write(s);
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
