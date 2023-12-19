import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int S = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            while (N-->0) {
                st = new StringTokenizer(br.readLine());
                S += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
            }
            sb.append(S).append('\n');
        }
        System.out.print(sb);
    }
}