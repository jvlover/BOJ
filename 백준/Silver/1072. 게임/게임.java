import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
        long Z = 100*Y/X;
        int ans = -1;
        if (Z < 99) ans = (int) Math.ceil((100.0*Y-(Z+1)*X)/(Z-99));
        System.out.print(ans);
    }
}