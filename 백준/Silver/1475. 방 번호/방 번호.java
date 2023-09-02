import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        while (N > 0) {
            ++arr[N%10];
            N /= 10;
        }
        int temp = arr[6]+arr[9];
        int max = temp%2==0 ? temp/2 : temp/2+1;
        for (int i = 0; i < 10; ++i) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, arr[i]);
        }
        System.out.print(max);
    }
}