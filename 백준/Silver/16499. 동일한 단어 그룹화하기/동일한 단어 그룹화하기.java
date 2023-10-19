import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        while (N-->0) hs.add(Arrays.stream(br.readLine().split("")).sorted().collect(Collectors.joining()));
        System.out.print(hs.size());
    }
}