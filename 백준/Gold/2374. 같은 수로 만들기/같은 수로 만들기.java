import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        int temp = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);
            if (num > temp) cnt += num-temp;
            temp = num;
        }
        cnt += max-temp;
        System.out.print(cnt);
    }
}