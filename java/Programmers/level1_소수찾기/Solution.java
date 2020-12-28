class Solution {
    public int solution(int n) {
       int count = 0;
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        arr[1] = true; // 0,1은 소수가 아님

        // 2 부터 숫자를 키워가며 배수 제외(true할당)
        for (int i = 2; i * i < n + 1; i++) {
            if (!arr[i]) { // 이미 소수로 제외된게 아닐 경우
                for (int j = i * i; j < n + 1; j += i) {
                    arr[j] = true;
                }
            }

        }
        for (int i = 0; i <= n; i += 1) {
            if (!arr[i]) {
                count++;
            }
        }
        return count;
    }
}
