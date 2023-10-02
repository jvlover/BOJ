import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb;
    static HashSet<Character> hs;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        hs = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        char ch;
        String str;
        outer: while (N-->0) {
            str = br.readLine();
            ch = str.charAt(0);
            if (!hs.contains(ch)) {
                assignShortCut(str, ch);
                continue;
            }
            int idx = -1;
            for (int i = 1; i < str.length(); ++i) {
                ch = str.charAt(i);
                if (str.charAt(i-1) == ' ' && !hs.contains(ch)) {
                    hs.add(ch);
                    if ('A' <= ch && ch <= 'Z') hs.add((char)(ch+32));
                    else hs.add((char)(ch-32));
                    idx = i;
                    break;
                }
            }
            if (idx != -1) {
                for (int i = 0; i < str.length(); ++i) {
                    ch = str.charAt(i);
                    if (i == idx) sb.append('[').append(ch).append(']');
                    else sb.append(ch);
                }
                sb.append('\n');
                continue outer;
            }
            for (int i = 0; i < str.length(); ++i) {
                ch = str.charAt(i);
                if (ch == ' ' || hs.contains(ch)) continue;
                assignShortCut(str, ch);
                continue outer;
            }
            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }
    static void assignShortCut(String word, char ch) {
        hs.add(ch);
        if ('A' <= ch && ch <= 'Z') hs.add((char)(ch+32));
        else hs.add((char)(ch-32));
        boolean flag = true;
        for (int i = 0; i < word.length(); ++i) {
            if (flag && ch == word.charAt(i)) {
                flag = false;
                sb.append('[').append(word.charAt(i)).append(']');
            }
            else sb.append(word.charAt(i));
        }
        sb.append('\n');
    }
}