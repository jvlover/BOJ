import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        for (String[] cloth : clothes) 
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 1)+1);
        int answer = 1;
        for (String str : hm.keySet())
            answer *= hm.get(str);
        return answer-1;
    }
}