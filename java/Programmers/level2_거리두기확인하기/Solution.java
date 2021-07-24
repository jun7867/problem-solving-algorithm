class Solution {
    static int[] dr = {-1,-1,0,1,1,1,0,-1,-1}; // 상 상우 우 하우 하 ...
    static int[] dc = {0,1,1,1,0,-1,-1,-1,0};
    static int[][] map;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        loop:
        for(int t=0;t<places.length;t++){
            answer[t]=1;
            map=new int[5][5];
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    map[i][j]=places[t][i].charAt(j);
                }
            }
            
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(map[i][j]=='P'){
                        boolean isPossible=check(i,j);
                        if(!isPossible){
                            answer[t]=0;
                            continue loop;
                        }
                            
                    }
                }
            }
        }
        
        return answer;
    }
    private boolean check(int r,int c){
        int nr=0;
        int nc=0;
        for(int i=0;i<8;i+=2){
            nr=r+dr[i];
            nc=c+dc[i];
            if(nr >=0 && nr<5 && nc>=0 && nc<5 && map[nr][nc] !='X'){
                if(map[nr][nc]=='P')
                    return false;
                else{ // 'O'
                    nr+=dr[i];
                    nc+=dc[i];
                    if(nr >=0 && nr<5 && nc>=0 && nc<5 && map[nr][nc]=='P')
                        return false;
                }
            }
        }
        
        for(int i=1;i<8;i+=2){
            nr=r+dr[i];
            nc=c+dc[i];
            if(nr >=0 && nr<5 && nc>=0 && nc<5 && map[nr][nc] =='P'){
                if(map[r+dr[i-1]][c+dc[i-1]] !='X' || map[r+dr[i+1]][c+dc[i+1]] !='X')
                    return false;
            }
        }
        return true;
    }
}
