import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        int left = 0, right = N-1, minLeft = -1, minRight = -1;
        long min = Integer.MAX_VALUE;
        while (left < right) {
            int num = arr[left]+arr[right], absNum = Math.abs(num);
            if (absNum < min) {
                min = absNum;
                minLeft = left;
                minRight = right;
            }
            if (num >= 0) --right;
            else ++left;
        }
        System.out.printf("%d %d", arr[minLeft], arr[minRight]);
    }
}