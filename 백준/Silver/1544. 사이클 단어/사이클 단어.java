import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        List<String>[] words = new ArrayList[N];
        outer: for (int i = 0; i < N; ++i) {
            words[i] = new ArrayList<>();
            String word = br.readLine();
            for (int j = 0; j < word.length(); ++j) words[i].add(word.substring(j)+word.substring(0, j));
            for (int j = 0; j < i; ++j)
                for (int k = 0; k < words[j].size(); ++k)
                    if (word.equals(words[j].get(k))) continue outer;
            ++cnt;
        }
        System.out.print(cnt);
    }
}