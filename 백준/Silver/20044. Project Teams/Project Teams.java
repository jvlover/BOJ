import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N*2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N*2; ++i) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) min = Math.min(min, arr[i]+arr[N*2-i-1]);
        System.out.print(min);
    }
}