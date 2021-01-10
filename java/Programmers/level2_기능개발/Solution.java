import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };
        Queue<Integer> q = new LinkedList<Integer>();

        int day = 0;
        int remain = 0;
        for (int i = 0; i < progresses.length; i++) {
            remain = 100 - progresses[i];
            if (remain % speeds[i] == 0) {
                q.add(remain / speeds[i]);
            } else {
                q.add(remain / speeds[i] + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int prev = q.poll();
        int num = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (prev >= cur) {
                num++;
            } else {
                list.add(num);
                num = 1;
                prev = cur;
            }
        }
        list.add(num);

        int[] answer= new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i]=list.get(i);
        }
    }
}
