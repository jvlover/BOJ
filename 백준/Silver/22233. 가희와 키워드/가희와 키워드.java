import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        while (N-->0) hs.add(br.readLine());
        while (M-->0) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) hs.remove(st.nextToken());
            sb.append(hs.size()).append('\n');
        }
        System.out.print(sb);
    }
}