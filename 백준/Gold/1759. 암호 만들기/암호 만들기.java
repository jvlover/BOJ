import java.io.*;
import java.util.*;
public class Main {
    static int L, C;
    static char[] arr;
    static boolean[] visit;
    static HashSet<Character> vowels;
    static StringBuilder sb = new StringBuilder();
    static char[] vowelArr = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; ++i) arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);
        vowels = new HashSet<>();
        for (char c : vowelArr) vowels.add(c);
        visit = new boolean[C];
        combination(0, 0, 0);
        System.out.print(sb);
    }
    static void combination(int idx, int vowel, int consonant) {
        if (vowel+consonant == L) {
            if (vowel < 1 || consonant < 2) return;
            for (int i = 0; i < C; ++i) if (visit[i]) sb.append(arr[i]);
            sb.append('\n');
            return;
        }
        for (int i = idx; i < C; ++i) {
            visit[i] = true;
            if (vowels.contains(arr[i])) combination(i+1, vowel+1, consonant);
            else combination(i+1, vowel, consonant+1);
            visit[i] = false;
        }
    }
}