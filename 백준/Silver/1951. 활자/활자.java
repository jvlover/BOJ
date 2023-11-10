import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int len = str.length();
        long sum = 0, num = 9;
        for (int i = 1; i < len; ++i) {
            sum += i*num;
            num *= 10;
        }
        StringBuilder minus = new StringBuilder();
        for (int i = 0; i < len-1; ++i) minus.append("9");
        System.out.print((sum+(N-Long.parseLong(minus.toString().equals("")?"0": minus.toString()))*len)%1234567);
    }
}