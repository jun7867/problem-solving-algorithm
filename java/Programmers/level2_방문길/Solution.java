class Solution {
    static int[] dr = {-1,0,1,0}; // 상우하좌 
    static int[] dc = {0,1,0,-1};
    static int nr,nc;
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        boolean[][][] visit = new boolean[11][11][4];
    
        int r=5;
        int c=5;
        for(int i=0;i<dirs.length();i++){
            int d =findDir(r,c,dirs.charAt(i));
            nr = r + dr[d];
            nc = c + dc[d];
            
            if(nr >= 0 && nr <= 10 && nc >= 0 && nc <= 10){
                int reverseD = (d + 2) % 4;
                if(!visit[nr][nc][d] && !visit[r][c][reverseD])
                    answer++;
                visit[nr][nc][d]=true;
                visit[r][c][reverseD]=true; // 반대방향도 체크해주기. 
                r = nr; // update 
                c = nc;
            }
        }
        
        
        return answer;
    }
    
    public int findDir(int r,int c,char dir){
        int d = 0;
        if(dir == 'U')
            d =0;
        else if(dir == 'R')
            d =1;
        else if(dir == 'D')
            d =2;
        else if(dir == 'L')
            d =3;
        
        return d;
    }
}
