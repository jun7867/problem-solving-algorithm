import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            HashMap<Integer, Double> map = new HashMap<>();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int ratio = N / 10;
            for (int i = 1; i <= N; i++) {
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                double c = sc.nextDouble();
                double score = a * 0.35 + b * 0.45 + c * 0.2;
                map.put(i, score);
            }
            List<Integer> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

            HashMap<Integer, String> gradeMap = new HashMap<>();
            String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
            int i = 0;
            for (Integer key : keySetList) {
                gradeMap.put(key, grade[i++ / ratio]);
            }
            System.out.println("#" + t + " " + gradeMap.get(K));
        }
    }
}

