import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int evenMin = Integer.MAX_VALUE, oddMin = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; ++i) {
            boolean isEven = false, isOdd = false;
            for (int j = i+1; j < N; ++j) {
                int gap = arr[j]-arr[i];
                if (!isEven && gap % 2 == 0) {
                    isEven = true;
                    evenMin = Math.min(evenMin, gap);
                } else if (!isOdd && gap % 2 == 1) {
                    isOdd = true;
                    oddMin = Math.min(oddMin, gap);
                }
                if (isEven && isOdd) break;
            }
        }
        int even = -1, odd = -1;
        if (evenMin != Integer.MAX_VALUE) even = evenMin;
        if (oddMin != Integer.MAX_VALUE) odd = oddMin;
        System.out.print(even + " " + odd);
    }
}