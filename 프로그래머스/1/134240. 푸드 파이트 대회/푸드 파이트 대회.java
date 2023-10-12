class Solution {
    public String solution(int[] food) {
        for (int i = 1; i < food.length; ++i)
            if (food[i] % 2 == 1) --food[i];
        StringBuilder sb = new StringBuilder("0");
        for (int i = food.length-1; i > 0; --i) {
            for (int j = 0; j < food[i]/2; ++j) sb.append(i);
            for (int j = 0; j < food[i]/2; ++j) sb.insert(0, i);
        }
        return sb.toString();
    }
}