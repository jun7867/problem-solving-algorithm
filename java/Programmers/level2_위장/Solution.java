import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(String key: map.keySet()){
            answer*=map.get(key)+1;
        }
        
        return answer-1; // 아무것도 안입는 경우는 없으니까 1 제외 
    }
}
