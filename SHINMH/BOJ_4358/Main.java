package BOJ_4358;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        String str = br.readLine();
        int count = 0;
        while(true){
            map.put(str, map.getOrDefault(str, 0) + 1);
            count++;
            str = br.readLine();
            if(str == null || str.length() == 0){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);

        for(Object key : keys){
            int num = map.get(key);
            double percent = (double) (num * 100) / count;
            sb.append(key + " " + String.format("%.4f", percent) + "\n");
        }
        System.out.println(sb.toString());
    }
}
