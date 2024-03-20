import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        String[] strings = new String[N];
        for (int i = 0; i < N; ++i) strings[i] = br.readLine();
        Set<String> hs = new HashSet<>();
        hs.add(str);
        Queue<String> q = new LinkedList<>();
        q.offer(str);
        while (!q.isEmpty()) {
            str = q.poll();
            for (String s : strings) {
                if (str.length() == s.length()-1 && !hs.contains(s)) {
                    int idx1 = 0, idx2 = 0, cnt = 0;
                    while (idx1 < str.length() && idx2 < s.length()) {
                        if (str.charAt(idx1) == s.charAt(idx2)) {
                            ++idx1;
                            ++idx2;
                        } else {
                            ++idx2;
                            ++cnt;
                        }
                    }
                    if (cnt == idx2-s.length()+1) {
                        hs.add(s);
                        q.offer(s);
                    }
                }
            }
        }
        System.out.print(str);
    }
}