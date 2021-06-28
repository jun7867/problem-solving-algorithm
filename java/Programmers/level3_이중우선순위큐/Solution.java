import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int len = operations.length;
        PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>();

        for(int i=0;i<len;i++){
            String[] str = operations[i].split(" ");
            int num = Integer.parseInt(str[1]);
            if(str[0].equals("I")){
                pqMax.add(num);
                pqMin.add(num);
            }else{ 
                if(num==1 && pqMax.size() > 0){
                    int max = pqMax.poll();
                    pqMin.remove(max);
                }else if(num==-1 && pqMin.size() > 0){
                    int min = pqMin.poll();
                    pqMax.remove(min);
                }
            }
        }
        if(pqMax.size() >0) {
            answer[0]=pqMax.poll();
            answer[1]=pqMin.poll();
        }
        
        return answer;
    }
}
