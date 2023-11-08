import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
        System.out.print(X+Y+Math.min(X, Y)/10);
    }
}