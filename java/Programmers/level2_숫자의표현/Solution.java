class Solution {
    public int solution(int n) {
        int cnt = 0;
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=0;
            int start=i;
            while(sum < n){
                sum+=start++;

                if(sum==n)
                    cnt++;
            }
            
        }
        
        return cnt;
    }
}
