package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_1708_볼록껍질 {
	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	        int N = Integer.parseInt(br.readLine());
	        ArrayList<Point> points = new ArrayList<>();

	        for (int i = 0; i < N; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());

	            points.add(new Point(x, y));
	        }

	        bw.write(grahamScan(points) + "\n");

	        br.close();
	        bw.flush();
	        bw.close();
	    }
	    static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
	    static int grahamScan(ArrayList<Point> input) {
	        for (int i = 0; i < input.size(); i++) {
	            if (input.get(i).y < root.y) {
	                root = input.get(i);
	            } else if (input.get(i).y == root.y) {
	                if (input.get(i).x < root.x) {
	                    root = input.get(i);
	                }
	            }
	        }
	        input.sort(new Comparator<Point>() {
	            @Override
	            public int compare(Point p1, Point p2) {    
	                int result = ccw(root, p1, p2);

	                if (result > 0) {
	                    return -1;
	                } else if (result < 0) {
	                    return 1;
	                } else {
	                    long distance1 = dist(root, p1);
	                    long distance2 = dist(root, p2);

	                    if (distance1 > distance2) {    
	                        return 1;
	                    }
	                }
	                return -1;
	            }
	        });
	        Stack<Point> stack = new Stack<>();
	        stack.add(root);

	        for (int i = 1; i < input.size(); i++) {
	            while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), input.get(i)) <= 0)) {    // first, second, next
	                stack.pop();    
	            }
	            stack.add(input.get(i));   
	        }

	        return stack.size();
	    }
	    static int ccw(Point p1, Point p2, Point p3) {
	        long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);

	        if (result > 0) {    
	            return 1;
	        } else if (result < 0) {    
	            return -1;
	        } else {
	            return 0;
	        }
	    }
	    static long dist(Point p1, Point p2) {
	        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	    }
	}