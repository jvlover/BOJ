import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int cnt0 = 0, cnt1 = 0;
        if (arr[0] == '0') ++cnt0;
        else ++cnt1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == '0' && arr[i-1] == '1') ++cnt0;
            else if (arr[i] == '1' && arr[i-1] == '0') ++cnt1;
        }
        System.out.print(Math.min(cnt0, cnt1));
    }
}