class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int unitDigit = storey%10, tenDigit = (storey/10)%10;
            
            if (unitDigit > 5) {
                answer += 10-unitDigit;
                storey += 10;
            } else {
                answer += unitDigit;
                if (unitDigit == 5 && tenDigit >= 5) storey += 10;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}