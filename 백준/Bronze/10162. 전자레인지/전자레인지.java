import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A = 0, B = 0, C = 0;
        while (N >= 10) {
            if (N >= 300) {
                A = N / 300;
                N %= 300;
            } else if (N >= 60) {
                B = N / 60;
                N %= 60;
            } else {
                C = N / 10;
                N %= 10;
            }
        }
        System.out.print(N == 0 ? String.format("%d %d %d", A, B, C) : -1);
    }
}