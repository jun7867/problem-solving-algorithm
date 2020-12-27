class Solution {
    public int solution(int n) {
        String s = "";
        int result = 0;
        while (n > 0) {
            s += String.valueOf(n % 3);
            n /= 3;
        }
        for (int i = 0; i < s.length(); i++) {
            result += (s.charAt(i) - '0') * (Math.pow(3, s.length() - i - 1));
        }
        return result;
    }
}
