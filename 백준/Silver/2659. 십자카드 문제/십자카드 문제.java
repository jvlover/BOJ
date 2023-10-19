import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < 4; ++i) temp.append(st.nextToken());
        int clockNum = getClockNum(Integer.parseInt(temp.toString()));
        int cnt = 0;
        for (int i = 1111; i <= clockNum; ++i)
            if (i == getClockNum(i)) ++cnt;
        System.out.print(cnt);
    }
    static int getClockNum(int num) {
        int clockNum = num;
        for (int i = 0; i < 3; ++i) {
            num = num%1000*10 + num/1000;
            clockNum = Math.min(clockNum, num);
        }
        return clockNum;
    }
}