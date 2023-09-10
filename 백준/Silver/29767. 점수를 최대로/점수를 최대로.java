import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Long[] arr = new Long[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < N; ++i) arr[i] = Long.parseLong(st.nextToken()) + arr[i-1];
        Arrays.sort(arr, Collections.reverseOrder());
        long ans = 0;
        for (int i = 0; i < K; ++i) ans += arr[i];
        System.out.print(ans);
    }
}