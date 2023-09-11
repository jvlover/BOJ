import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        int[] ascDp = new int[N], descDp = new int[N];
        ascDp[0] = descDp[0] = 1;
        for (int i = 1; i < N; ++i) {
            ascDp[i] = arr[i] <= arr[i-1] ? ascDp[i-1]+1 : 1;
            descDp[i] = arr[i] >= arr[i-1] ? descDp[i-1]+1 : 1;
        }
        int max = 0;
        for (int i = 0; i < N; ++i) max = Math.max(max, Math.max(ascDp[i], descDp[i]));
        System.out.print(max);
    }
}