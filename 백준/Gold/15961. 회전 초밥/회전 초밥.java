import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+K-1];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(br.readLine());
        for (int i = N; i < N+K-1; ++i) arr[i] = arr[i-N];
        int[] eat = new int[D+1];
        ++eat[C];
        int ans = 1;
        for (int i = 0; i < K; ++i)
            if (eat[arr[i]]++ == 0) ++ans;
        int temp = ans;
        for (int left = 0, right = K; right < N+K-1; ++left, ++right) {
            --eat[arr[left]];
            if (eat[arr[left]] == 0) --temp;
            if (eat[arr[right]] == 0) ++temp;
            ++eat[arr[right]];
            ans = Math.max(ans, temp);
        }
        System.out.print(ans);
    }
}