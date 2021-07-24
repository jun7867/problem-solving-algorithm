class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        
        loop:
        for(int i=3;i<total;i++){
            for(int j=total/i;j<total;j++){
                int mul=i*j;
                if(mul < total)
                    continue;
                else if(mul >total)
                    break;
                else if(mul==total && (i-2)*(j -2) == yellow){
                    answer[0]=j;
                    answer[1]=i;
                    break loop;
                }
            }
        }
        
        
        return answer;
    }
}
