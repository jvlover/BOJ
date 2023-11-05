import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            String bin = Integer.toString(Integer.parseInt(br.readLine()), 2);
            for (int i = bin.length()-1, j = 0; i >= 0; --i, ++j)
                if (bin.charAt(i) == '1') sb.append(j).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}