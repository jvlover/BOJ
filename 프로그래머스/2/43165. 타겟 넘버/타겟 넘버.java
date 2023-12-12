class Solution {
    int target, answer;
    int[] numbers;
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        this.answer = 0;
        
        dfs(0, 0);
        
        return answer;
    }
    void dfs(int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) ++answer;
            return;
        }
        dfs(idx+1, sum+numbers[idx]);
        dfs(idx+1, sum-numbers[idx]);
    }
}