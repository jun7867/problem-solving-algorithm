import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        String[] skill_set = skill.split("");
        Stack<String> stack = new Stack<String>();
        int count = 0;
        boolean isFail = false;

        for (int i = 0; i < skill_trees.length; i++) {
            isFail = false;
            stack.clear();
            for (int k = skill_set.length; k > 0; k--) {
                stack.push(skill_set[k - 1]);
            }
            String[] temp = skill_trees[i].split("");
            for (int j = 0; j < temp.length; j++) {
                if (skill.indexOf(temp[j]) != -1) {
                    if (stack.peek().equals(temp[j])) {
                        stack.pop();
                    } else {
                        isFail = true;
                        break;
                    }
                }
            }
            if (!isFail) {
                count++;
            }
        }
        
        return count;
    }
}
