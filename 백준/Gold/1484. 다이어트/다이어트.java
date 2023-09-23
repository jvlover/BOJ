import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long start = 1, end = 2;
        while (end <= 100000) {
            long gap = end*end - start*start;
            if (gap == N) sb.append(end).append('\n');
            if (gap > N) ++start;
            else ++end;
        }
        System.out.print(sb.length()>0?sb:-1);
    }
}