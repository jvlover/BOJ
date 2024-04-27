import java.util.*;

class Solution {
    public int solution(String[] words) {
        Arrays.sort(words);
        int[] cnt = new int[words.length];
        
        for (int i = 0; i < words.length-1; ++i) {
            int len = Math.min(words[i].length(), words[i+1].length());
            int prefixLen = getPrefixLen(words[i], words[i+1], len);
            
            if (len == prefixLen) cnt[i] = Math.max(cnt[i], prefixLen);
            else cnt[i] = Math.max(cnt[i], prefixLen+1);
            
            cnt[i+1] = prefixLen+1;
        }
        
        return Arrays.stream(cnt).sum();
    }
    int getPrefixLen(String now, String next, int len) {
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            if (now.charAt(i) == next.charAt(i)) ++cnt;
            else return cnt;
        }
        return cnt;
    }
}