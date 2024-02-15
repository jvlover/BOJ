import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine()), T = new StringBuilder(br.readLine());
        while (S.length() != T.length()) {
            if (T.charAt(T.length()-1) == 'A') {
                T.setLength(T.length()-1);
            } else if (T.charAt(T.length()-1) == 'B') {
                T.setLength(T.length()-1);
                T.reverse();
            }
        }
        System.out.print(S.toString().contentEquals(T) ? 1 : 0);
    }
}