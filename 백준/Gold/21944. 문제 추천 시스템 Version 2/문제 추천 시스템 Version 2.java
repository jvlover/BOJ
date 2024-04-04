import java.io.*;
import java.util.*;
public class Main {
    static class Problem implements Comparable<Problem> {
        int idx, level, algo;
        Problem(int idx, int level, int algo) {
            this.idx = idx;
            this.level = level;
            this.algo = algo;
        }
        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) return Integer.compare(o.idx, this.idx);
            return Integer.compare(o.level, this.level);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> ts = new TreeSet<>();
        Map<Integer, TreeSet<Problem>> treeSetMap = new HashMap<>();
        Map<Integer, Integer> levelMap = new HashMap<>(), groupMap = new HashMap<>();
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()), G = Integer.parseInt(st.nextToken());
            Problem prob = new Problem(P, L, G);
            ts.add(prob);
            treeSetMap.putIfAbsent(G, new TreeSet<>());
            treeSetMap.get(G).add(prob);
            levelMap.put(P, L);
            groupMap.put(P, G);
        }
        int M = Integer.parseInt(br.readLine());
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
                sb.append(x == 1 ? treeSetMap.get(G).first().idx : treeSetMap.get(G).last().idx).append('\n');
            } else if (command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(x == 1 ? ts.first().idx : ts.last().idx).append('\n');
            } else if (command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    Problem floor = ts.floor(new Problem(0, L, 0));
                    sb.append(floor == null ? -1 : floor.idx);
                } else {
                    Problem ceiling = ts.ceiling(new Problem(0, L, 0));
                    sb.append(ceiling == null ? -1 : ceiling.idx);
                }
                sb.append('\n');
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()), G = Integer.parseInt(st.nextToken());
                Problem prob = new Problem(P, L, G);
                ts.add(prob);
                treeSetMap.putIfAbsent(G, new TreeSet<>());
                treeSetMap.get(G).add(prob);
                levelMap.put(P, L);
                groupMap.put(P, G);
            } else {
                int P = Integer.parseInt(st.nextToken()), L = levelMap.get(P), G = groupMap.get(P);
                Problem prob = new Problem(P, L, G);
                ts.remove(prob);
                treeSetMap.get(G).remove(prob);
                levelMap.remove(P);
                groupMap.remove(P);
            }
        }
        System.out.print(sb);
    }
}