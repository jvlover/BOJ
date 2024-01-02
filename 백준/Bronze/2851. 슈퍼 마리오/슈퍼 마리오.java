import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        arr[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < 10; ++i) arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        int ans = Integer.MIN_VALUE, gap = Integer.MAX_VALUE;
        for (int i = 0; i < 10; ++i) {
            int temp = Math.abs(100-arr[i]);
            if (gap >= temp) {
                gap = temp;
                ans = Math.max(ans, arr[i]);
            }
        }
        System.out.print(ans);
    }
}