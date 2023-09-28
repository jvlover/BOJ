import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        String str;
        if (N >= 1000) {
            if (U >= 8000 || L >= 260) str = "Very Good";
            else str = "Good";
        } else {
            str = "Bad";
        }
        System.out.print(str);
    }
}