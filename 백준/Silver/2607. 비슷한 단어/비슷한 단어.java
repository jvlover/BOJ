import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())-1;
        char[] str = br.readLine().toCharArray();
        int ans = 0;
        while (N-->0) {
            char[] cur = br.readLine().toCharArray();
            int[] alphabet = new int[26];
            for (char c : str) ++alphabet[c-'A'];
            int cnt = 0;
            for (char c : cur) {
                if (alphabet[c-'A'] > 0) {
                    ++cnt;
                    --alphabet[c-'A'];
                }
            }
            if ((str.length == cur.length-1 && cnt == cur.length-1) || (str.length == cur.length+1 && cnt == cur.length) || (str.length == cur.length && (str.length == cnt || str.length == cnt+1))) ++ans;
        }
        System.out.print(ans);
    }
}