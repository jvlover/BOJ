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
            int gap1 = i < N-2 ? arr[i+2]-arr[i] : Integer.MAX_VALUE;
            int gap2 = arr[i+1]-arr[i];
            if (gap2 % 2 == 0) evenMin = Math.min(evenMin, gap2);
            else if (gap1 % 2 == 0) evenMin = Math.min(evenMin, gap1);
            if (gap2 % 2 == 1) oddMin = Math.min(oddMin, gap2);
            else if (gap1 % 2 == 1) oddMin = Math.min(oddMin, gap1);
        }
        int even = -1, odd = -1;
        if (evenMin != Integer.MAX_VALUE) even = evenMin;
        if (oddMin != Integer.MAX_VALUE) odd = oddMin;
        System.out.print(even + " " + odd);
    }
}