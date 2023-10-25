import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, min = 100;
        for (int i = 0; i < 7; ++i) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 0) continue;
            sum += num;
            min = Math.min(min, num);
        }
        System.out.print(sum == 0 ? -1 : sum+"\n"+min);
    }
}