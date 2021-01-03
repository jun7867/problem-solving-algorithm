import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
         HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                hm.put(1, hm.getOrDefault(1, 0) + 1);
            }
            if (answers[i] == b[i % b.length]) {
                hm.put(2, hm.getOrDefault(2, 0) + 1);
            }
            if (answers[i] == c[i % c.length]) {
                hm.put(3, hm.getOrDefault(3, 0) + 1);
            }
        }
        Collection values = hm.values();
        int maxV = (int) Collections.max(values);
        for (Integer key : hm.keySet()) {
            if (hm.get(key) == maxV) {
                list.add(key);
            }
        }
        int[] answer=new int[list.size()];
        for (int i=0; i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}
