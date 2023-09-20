import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        boolean[] broken = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        while (S-->0) broken[Integer.parseInt(st.nextToken())] = true;
        boolean[] spare = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        while (R-->0) {
            int idx = Integer.parseInt(st.nextToken());
            if (!broken[idx]) spare[idx] = true;
            else broken[idx] = false;
        }
        if (broken[1] && spare[2]) broken[1] = spare[2] = false;
        if (broken[N] && spare[N-1]) broken[N] = spare[N-1] = false;
        for (int i = 2; i <= N-1; ++i) {
            if (!broken[i]) continue;
            if (spare[i+1]) broken[i] = spare[i+1] = false;
            else if (spare[i-1]) broken[i] = spare[i-1] = false;
        }
        int cnt = 0;
        for (boolean b : broken) if (b) ++cnt;
        System.out.print(cnt);
    }
}