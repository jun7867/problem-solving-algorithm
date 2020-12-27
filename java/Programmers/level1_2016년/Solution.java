class Solution {
    public String solution(int a, int b) {
        int[] month = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31 };
        String[] week = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };

        int day = 0;
        for (int i = 0; i < a; i++)
            day += month[i];
        day+=b;
        System.out.println(week[day % 7]);
        return week[day % 7];
    }
}
