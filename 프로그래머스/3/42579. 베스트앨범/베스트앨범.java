import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < genres.length; ++i)
            hm.put(genres[i], hm.getOrDefault(genres[i], 0)+plays[i]);
        
        List<String> genreList = new ArrayList<>(hm.keySet());
        Collections.sort(genreList, (o1, o2) -> Integer.compare(hm.get(o2), hm.get(o1)));
        
        List<Integer> answer = new ArrayList<>();
        for (String s : genreList) {
            int firstIdx = -1, secondIdx = -1, max = Integer.MIN_VALUE;
            for (int i = 0; i < genres.length; ++i) {
                if (s.equals(genres[i]) && max < plays[i]) {
                    firstIdx = i;
                    max = plays[i];
                }
            }
            
            max = Integer.MIN_VALUE;
            for (int i = 0; i < genres.length; ++i) {
                if (s.equals(genres[i]) && max < plays[i] && firstIdx != i) {
                    secondIdx = i;
                    max = plays[i];
                }
            }
            
            answer.add(firstIdx);
            if (secondIdx != -1) answer.add(secondIdx);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}