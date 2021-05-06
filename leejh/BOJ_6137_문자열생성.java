package leejh;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BOJ_6137_문자열생성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];
		for(int i = 0; i < N;i++) arr[i] = br.readLine().charAt(0);
		int start=0,end=N-1,cnt=0; // cnt : 줄바꿈 위한 counter
		while(cnt < N) { // 모든 문자 처리
			if(arr[start]<arr[end]) { // 처음 문자가 더 작을 때
				bw.write(arr[start]);
				start++;
			}else if(arr[start]==arr[end]){ // 처음과 끝 문자가 같을 때
				int s = start+1, e = end-1;
				while(s<e) { // 처음과 끝이 같지 않은 index 탐색
					if(arr[s]!=arr[e])break;
					s++;e--;
				}
				if(arr[s]<arr[e]) { // 처음과 끝이 같지 않은 index의 값 비교
					for(int i = start;i <= s;i++) {
					bw.write(arr[start]);
					start++;
					if(cnt%80==0) break;
					}
				}else {
					for(int i = end; i >= e;i--) {
					bw.write(arr[end]);
					end--;
					if(cnt%80==0) break;
					}
				}
			}
			else { // 끝 문자가 더 작을 때
				bw.write(arr[end]);
				end--;
			}
			cnt++;
			if(cnt%80==0) bw.write("\n");
		}
		bw.close();
	}
}
