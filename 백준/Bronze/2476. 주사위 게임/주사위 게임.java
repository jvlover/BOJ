import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            int temp;
            if (a == b && b == c) temp = 10000 + 1000*a;
            else if (a == b) temp = 1000 + 100*a;
            else if (b == c) temp = 1000 + 100*b;
            else if (a == c) temp = 1000 + 100*c;
            else temp = 100*(Math.max(a, Math.max(b, c)));
            max = Math.max(max, temp);
        }
        System.out.print(max);
    }
}