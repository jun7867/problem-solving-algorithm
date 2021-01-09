import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int currentWeightSum = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int w : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(w);
                    currentWeightSum += w;
                    time++;
                    break;
                } else if (q.size() == bridge_length){
                    currentWeightSum-=q.poll();
                } else {
                    if (weight < currentWeightSum + w){
                        q.add(0);
                        time++;
                    } else{
                        q.add(w);
                        currentWeightSum+=w;
                        time++;
                        break;
                    }
                }
            }
        }
        time+=bridge_length;
        
        return time;
    }
}
