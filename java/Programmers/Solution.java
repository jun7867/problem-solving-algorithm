import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();

        for (int n : priorities) {
            q.add(n);
        }
        int max = q.peek();
        int count = 0;
        while (!q.isEmpty()) {
            max = Collections.max(q);

            if (location == 0) {
                if (q.peek() < max) {
                    q.add(q.poll());
                    location = q.size() - 1; // 0번째 것이 제일 뒤로 갔으므로 (길이-1)이 맨 뒤에 찾아야 하는 값이다.
                } else {
                    count++;
                    break;
                }
            } else {
                if (q.peek() < max) {
                    q.add(q.poll());
                    location--;
                } else {
                    q.poll();
                    location--;
                    count++;
                }
            }
        }
        
        return count;
    }
}
