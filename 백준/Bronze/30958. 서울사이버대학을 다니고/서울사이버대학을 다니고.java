import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < N; ++i)
            if ('a' <= arr[i] && arr[i] <= 'z') ++cnt[arr[i]-'a'];
        int ans = 0;
        for (int i : cnt) ans = Math.max(ans, i);
        System.out.print(ans);
    }
}