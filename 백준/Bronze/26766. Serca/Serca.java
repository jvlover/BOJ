import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-->0) {
            sb.append(" @@@   @@@ \n" +
                    "@   @ @   @\n" +
                    "@    @    @\n" +
                    "@         @\n" +
                    " @       @ \n" +
                    "  @     @  \n" +
                    "   @   @   \n" +
                    "    @ @    \n" +
                    "     @     \n");
        }
        System.out.print(sb);
    }
}