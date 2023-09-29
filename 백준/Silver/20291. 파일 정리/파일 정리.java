import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tm = new TreeMap<>();
        while (N-->0) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String str = st.nextToken();
            tm.put(str, tm.getOrDefault(str, 0)+1);
        }
        for (Map.Entry<String, Integer> entry : tm.entrySet())
            sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        System.out.print(sb);
    }
}