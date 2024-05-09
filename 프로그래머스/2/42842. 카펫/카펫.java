class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown+yellow;
        for (int row = 3; row < total; ++row) {
            int col = total/row;
            if (yellow == (row-2)*(col-2)) {
                return new int[] {col, row};
            }
        }
        return answer;
    }
}