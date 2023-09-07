import java.io.*;
import java.util.*;
public class Main {
    static HashMap<String, Integer> hm = new HashMap<>();
    static class Word implements Comparable<Word> {
        String word;
        Word(String word) {
            this.word = word;
        }
        @Override
        public int compareTo(Word o) {
            if (!hm.get(this.word).equals(hm.get(o.word)))
                return Integer.compare(hm.get(o.word), hm.get(this.word));
            else if (this.word.length() != o.word.length())
                return Integer.compare(o.word.length(), this.word.length());
            return this.word.compareTo(o.word);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        while (N-->0) {
            String word = br.readLine();
            if (word.length() >= M)
                hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Word> pq = new PriorityQueue<>();
        for (String str : hm.keySet()) pq.offer(new Word(str));
        while (!pq.isEmpty()) sb.append(pq.poll().word).append('\n');
        System.out.print(sb);
    }
}