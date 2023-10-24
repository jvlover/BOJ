import java.io.*;
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N*2; ++i) print1();
        for (int i = 1; i <= N; ++i) print2();
        for (int i = 1; i <= N; ++i) print1();
        for (int i = 1; i <= N; ++i) print2();
        System.out.print(sb);
    }
    static void print1() {
        for (int i = 1; i <= N; ++i) sb.append('@');
        for (int i = 1; i <= N*3; ++i) sb.append(' ');
        for (int i = 1; i <= N; ++i) sb.append('@');
        sb.append('\n');
    }
    static void print2() {
        for (int i = 1; i <= N*5; ++i) sb.append('@');
        sb.append('\n');
    }
}