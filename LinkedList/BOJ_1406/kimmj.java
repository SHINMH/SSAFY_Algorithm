package LinkedList/BOJ_1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class kimmj {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Character> list= new LinkedList<>();
		String str= br.readLine();
		
		for (int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		ListIterator<Character> cursor= list.listIterator(list.size());
		int M= Integer.parseInt(br.readLine());
		
		for (int m=0; m<M; m++) {
			String command= br.readLine();
			switch(command.charAt(0)) {
				case 'L':
					if (cursor.hasPrevious()) {
						cursor.previous();
					}
					break;
				case 'D':
					if (cursor.hasNext()) {
						cursor.next();
					}
					break;
				case 'B':
					if (cursor.hasPrevious()) {
						cursor.previous();
						cursor.remove();
					}
					break;
				case 'P':
					cursor.add(command.charAt(2));
					break;
			}
		}
		for (Character c: list) {
			bw.write(c);
		}
		br.close();
		bw.close();
	}
}
