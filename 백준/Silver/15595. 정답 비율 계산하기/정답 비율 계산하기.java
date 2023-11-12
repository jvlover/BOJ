import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int correctCnt = 0, totalCnt = 0;
        Map<String, Integer> hm = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String id = st.nextToken();
            int temp = hm.getOrDefault(id, 0);
            if (id.equals("megalusion") || temp == -1) continue;
            ++temp;
            if (st.nextToken().equals("4")) {
                ++correctCnt;
                totalCnt += temp;
                temp = -1;
            }
            hm.put(id, temp);
        }
        System.out.print(totalCnt==0 ? 0 : (double)correctCnt/totalCnt*100);
    }
}