import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5*cities.length;
        
        int answer = 0;
        
        LinkedList<String> cache = new LinkedList<>();
        for (String str : cities) {
            String city = str.toLowerCase();
            
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                ++answer;
            } else {
                if (cacheSize <= cache.size()) cache.remove();
                cache.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}