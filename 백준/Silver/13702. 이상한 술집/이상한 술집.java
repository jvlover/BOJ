import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(br.readLine());
        long start = 0, end = Integer.MAX_VALUE;
        while (start <= end) {
            long mid = (start+end)/2;
            int cnt = 0;
            for (int i = 0; i < N; ++i) cnt += arr[i]/mid;
            if (cnt >= K) start = mid+1;
            else end = mid-1;
        }
        System.out.print(end);
    }
}