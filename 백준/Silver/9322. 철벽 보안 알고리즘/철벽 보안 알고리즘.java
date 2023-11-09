import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> hm = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) hm.put(st.nextToken(), i);
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) arr[i] = hm.get(st.nextToken());
            String[] ans = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) ans[arr[i]] = st.nextToken();
            for (String str : ans) sb.append(str).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}