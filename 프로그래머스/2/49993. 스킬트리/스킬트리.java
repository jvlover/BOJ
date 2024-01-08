class Solution {
    public int solution(String skill, String[] skill_trees) {
        boolean[] alphas = new boolean[26];
        for (int i = 0; i < skill.length(); ++i) {
            alphas[skill.charAt(i)-'A'] = true;
        }
        
        int cnt = 0;
        outer: for (String skillTree : skill_trees) {
            int idx = 0;
            for (int i = 0; i < skillTree.length(); ++i) {
                if (!alphas[skillTree.charAt(i)-'A']) continue;
                if (skillTree.charAt(i) == skill.charAt(idx)) ++idx;
                else continue outer;
            }
            ++cnt;
        }
        
        return cnt;
    }
}