import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[] factorials = new long[21];
        for (int i = 0; i <= 20; ++i) {
            factorials[i] = 1;
            for (int j = 1; j <= i; ++j) factorials[i] *= j;
        }
        boolean flag = N != 0;
        for (int i = 20; i >= 0; --i)
            if (N >= factorials[i]) N -= factorials[i];
        System.out.print(flag && N==0 ? "YES" : "NO");
    }
}