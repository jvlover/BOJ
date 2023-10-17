import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            StringBuilder temp = new StringBuilder();
            double max = 0;
            while (N-->0) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                if (height > max) {
                    temp = new StringBuilder();
                    max = height;
                }
                if (height >= max) temp.append(name).append(' ');
            }
            sb.append(temp).append('\n');
        }
        System.out.print(sb);
    }
}