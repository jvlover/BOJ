import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < 26; ++i) hm.put(Character.toString((char)('A'+i)), i+1);
        
        int idx = 0;
        List<Integer> answer = new ArrayList<>();
        while (true) {
            String str = "";
            while (idx < msg.length()) {
                if (!hm.containsKey(str+msg.charAt(idx))) break;
                else str += msg.charAt(idx);
                ++idx;
            }
            answer.add(hm.get(str));
            if (idx < msg.length()) hm.put(str+msg.charAt(idx), hm.size()+1);
            else break;
        }
        
        return answer;
    }
}