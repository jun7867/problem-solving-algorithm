import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        double ratio = 0.0;
        Map<Integer, Double> map = new HashMap<>();
        int[] answer=new int[N];

        for (int i = 1; i < N + 1; i++) {
            int cntPlay = 0;
            int cntFail = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    if (stages[j] == i) {
                        cntFail++;
                    }
                    cntPlay++;
                }
            }
            if (cntPlay == 0) {
                cntPlay++;
            }
            ratio = (double) cntFail / cntPlay;
            map.put(i, ratio);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        // 내림차순
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        
        int count=0;
        for(Integer key: keySetList){
            answer[count++]=key;
        }
        
        return answer;
    }
}
