import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int money;
        if (a == b && b == c) money = 10000 + 1000 * a;
        else if (a == b) money = 1000 + 100 * a;
        else if (b == c) money = 1000 + 100 * b;
        else if (a == c) money = 1000 + 100 * c;
        else money = 100 * Math.max(a, Math.max(b, c));
        System.out.print(money);
    }
}