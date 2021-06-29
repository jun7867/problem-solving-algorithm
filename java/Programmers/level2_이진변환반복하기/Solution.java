
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero=0;
        int cnt=0;
        StringBuilder sb = new StringBuilder("");
        
        while(!s.equals("1")){
            int len = s.length();
            for(int i=0;i<len;i++){
                char c = s.charAt(i);
                if(c=='1')
                    sb.append(c);
                else
                    zero++;
            }
            int slength = sb.toString().length();
            
            s=Integer.toBinaryString(slength);
            sb = new StringBuilder("");
            cnt++;
        }
        
        answer[0]=cnt;
        answer[1]=zero;
        
        return answer;
    }
}
