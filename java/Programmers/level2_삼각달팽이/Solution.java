class Solution {
    public int[] solution(int n) {
        int max = (n * (n + 1)) / 2;
        int[][] arr = new int[n][n];
        int[] answer = new int[max];
    
        //초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = -1;
            }
        }

        int i = 0, j = 0, k = 1;
        arr[0][0] = 1;

        while (k < max) {
            while (i + 1 < n && arr[i + 1][j] < 0) { // 왼쪽 대각선
                arr[++i][j] = ++k;
            }

            while (j + 1 < n && arr[i][j + 1] < 0) { // 맨 밑 가로
                arr[i][++j] = ++k;
            }
            while (i - 1 > 0 && arr[i - 1][j - 1] < 0) { // 오른쪽 대각선
                arr[--i][--j] = ++k;
            }
            // 한바퀴 돌면 i+1,j+1 상태.=> (2,1)부터 다시 검사.
        }
        k = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                answer[k++] = arr[i][j];
            }
        }
        return answer;
    }
}
