import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<String> prefixes = new HashSet<>();
        HashMap<String, Integer> names = new HashMap<>();
        while (N-->0) {
            String name = br.readLine();
            if (names.containsKey(name)) {
                names.put(name, names.get(name)+1);
                sb.append(name).append(names.get(name)).append('\n');
                continue;
            }
            boolean flag = false;
            for (int i = 1; i <= name.length(); ++i) {
                String str = name.substring(0, i);
                if (!prefixes.contains(str)) {
                    prefixes.add(str);
                    if (!flag) {
                        flag = true;
                        names.put(name, 1);
                        sb.append(str).append('\n');
                    }
                }
            }
            if (!flag) {
                names.put(name, 1);
                sb.append(name).append('\n');
            }
        }
        System.out.print(sb);
    }
}