import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                tempList.add(arr[i]);
            }
        }
        if (tempList.size()==0){
            int[] answer={-1};
            return answer;
        }
        Collections.sort(tempList);
        
        int[] answer = new int[tempList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }
}
