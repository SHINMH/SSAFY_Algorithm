package SW_3289;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        make(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            set.add(find(i));
        }
        System.out.println(set.size());
    }

    static void make(int n) {
        array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = i;
        }
    }

    static int find(int a) {
        if (a == array[a]) return a;
        return array[a] = find(array[a]);
    }

    static boolean union(int a, int b) {
        int aGroup = find(a);
        int bGroup = find(b);

        if (aGroup == bGroup) return false;
        array[bGroup] = aGroup;
        return true;
    }
}
