import java.io.*;
import java.util.*;
public class Main {
    static class Problem implements Comparable<Problem> {
        int level, time;
        Problem(int level, int time) {
            this.level = level;
            this.time = time;
        }
        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) return Integer.compare(this.time, o.time);
            return Integer.compare(this.level, o.level);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 5; ++i) levels[i] = Integer.parseInt(st.nextToken());
        Problem[] problems = new Problem[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(problems);
        int idx = 1, cnt = 0, sum = 0;
        for (int i = 0; i < N; ++i) {
            if (levels[idx] <= cnt && problems[i].level == idx) {
                continue;
            } else if (problems[i].level != idx) {
                cnt = 0;
                ++idx;
                sum += 60;
            } else if (i != 0 && problems[i].level == idx) {
                sum += problems[i].time - problems[i-1].time;
            }
            ++cnt;
            sum += problems[i].time;
        }
        System.out.print(sum);
    }
}