import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        for (int t = 1; t <= K; ++t) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            sb.append("Class ").append(t).append('\n');
            int[] arr = new int[N];
            for (int i = 0; i < N; ++i)
                arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int maxGap = Integer.MIN_VALUE;
            for (int i = 1; i < N; ++i)
                maxGap = Math.max(maxGap, arr[i]-arr[i-1]);
            sb.append(String.format("Max %d, Min %d, Largest gap %d\n", arr[N-1], arr[0], maxGap));
        }
        System.out.print(sb);
    }
}