import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int N = Integer.parseInt(br.readLine()), max = N;
            while (N != 1) {
                if (N%2 == 0) N /= 2;
                else N = N*3+1;
                max = Math.max(max, N);
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }
}