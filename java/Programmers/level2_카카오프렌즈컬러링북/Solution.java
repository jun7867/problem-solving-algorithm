import java.util.*;
class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea=0;
        int maxSizeOfOneArea=0;
        int areaSize=0;
        
        long[][] p = new long[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                p[i][j]=(long)picture[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] !=0) {
                    areaSize = dfs(m, n, i, j, p[i][j],p);
                    if (maxSizeOfOneArea < areaSize){
                        maxSizeOfOneArea = areaSize;
                    }
                    numberOfArea++;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    static int dfs(int m, int n, int x, int y, long prev,long[][] p) {
        int tempCount=1;
        
        // 전에 확인한 값이랑 같은 영역인지 확인 
        if (p[x][y] !=prev)
            return 0;
        
        // 지나갔다는 표시로 0으로 바꿈.
        p[x][y] =0;

        for (int i=0; i< 4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            // 범위 초과하면 pass
            if (nx <0 || nx >=m || ny <0 || ny >=n) continue;
            
            // 이전 값이랑 다르거나 0이면 pass
            if (p[nx][ny] ==0 || p[nx][ny] !=prev) continue;
            
            
            tempCount+=dfs(m,n,nx,ny,prev,p);
        }
        return tempCount;
    }
}
