import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static Title[] titles;
    static class Title {
        String title;
        int standard;
        Title(String title, int standard) {
            this.title = title;
            this.standard = standard;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        titles = new Title[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            titles[i] = new Title(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        while (M-->0) sb.append(binarySearch(Integer.parseInt(br.readLine()))).append('\n');
        System.out.print(sb);
    }
    static String binarySearch(int num) {
        int left = 0, right = N-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (num <= titles[mid].standard) right = mid-1;
            else left = mid+1;
        }
        return titles[left].title;
    }
}