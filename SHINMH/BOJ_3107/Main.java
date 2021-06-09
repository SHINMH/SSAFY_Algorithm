package BOJ_3107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        makeIp6(str);
    }

    static void makeIp6(String str){
        String[] ipSplit = str.split(":");
        String[] result = new String[8];
        if(ipSplit.length == 8){
            System.out.println(makeIp(ipSplit));
        }else { // 중간에 ::가 있는 경우
            System.out.println(ipSplit.length);
            if(ipSplit.length == 0){ // ::만 있는 경우
                ipSplit = new String[8];
                for(int i = 0; i < 8; i++){
                    ipSplit[i] = "0000";
                }
            } else {

            }
        }
    }

    static String makeIp(String[] ip){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < 8; i++){
            StringBuilder tempStr = new StringBuilder();
            int size = ip[i].length();
            if(size == 4) continue;
            if(ip[i].equals("")){
                ip[i] = "0000";
            }else{
                for(int j = 0; j < 4 - size; j++){
                    tempStr.append(0);
                }
                tempStr.append(ip[i]);
                ip[i] = tempStr.toString();
            }
        }
        for(int i = 0; i < 8; i++){
            result.append(ip[i] + ":");
        }
        result.setLength(result.length() - 1);

        return result.toString();
    }
}
