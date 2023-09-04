import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        int[] friends = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) friends[i] = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < M; ++i) {
            boolean flag = true;
            for (int friend : friends) {
                if (arr[i] == friend) {
                    flag = false;
                    break;
                }
            }
            if (flag) ++ans;
        }
        System.out.print(ans);
    }
}