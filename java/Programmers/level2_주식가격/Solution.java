import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < prices.length - 1; i++) {
            boolean isFinish = false;
            for (int j = i; j < prices.length - 1; j++) {
                if (prices[i] > prices[j + 1]) {
                    list.add(j - i + 1);
                    isFinish = true;
                    break;
                }
            }
            if (!isFinish) {
                list.add(prices.length - i - 1);
            }
        }
        list.add(0);

        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}
