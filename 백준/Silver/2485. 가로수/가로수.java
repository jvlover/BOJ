import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int gcd = 0;
        int start = Integer.parseInt(br.readLine());
        int prev = start;
        for (int i = 1; i < N; ++i) {
            int cur = Integer.parseInt(br.readLine());
            int gap = cur-prev;
            gcd = gcd(Math.max(gcd, gap), Math.min(gcd, gap));
            prev = cur;
        }
        int end = prev;
        System.out.print((end-start)/gcd+1-N);
    }
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}