import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashSet<Integer> setLost = new HashSet<Integer>();
        HashSet<Integer> setReserve = new HashSet<Integer>();
        for (int i : reserve) {
            setReserve.add(i);
        }
        for (int i : lost) {
            if (setReserve.contains(i)) {
                setReserve.remove(i);
            } else {
                setLost.add(i);
            }
        }
        for (int i : lost) {
            if (setLost.contains(i)) {
                if (setReserve.contains(i - 1)) {
                    setReserve.remove(i - 1);
                } else if (setReserve.contains(i + 1)) {
                    setReserve.remove(i + 1);
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}
