import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        TreeSet<Integer> A = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        while (nA-->0) A.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        while (nB-->0) A.remove(Integer.parseInt(st.nextToken()));
        StringBuilder sb = new StringBuilder();
        sb.append(A.size()).append('\n');
        for (int i : A) sb.append(i).append(' ');
        System.out.print(sb);
    }
}