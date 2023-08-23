import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < N) {
            int gap = arr[right] - arr[left];
            if (gap < M) ++right;
            else {
                ++left;
                if ((ans = Math.min(ans, gap)) == M) break;
            }
        }
        System.out.print(ans);
    }
}