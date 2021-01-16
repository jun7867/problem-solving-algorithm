import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            String s = sc.next();
            for (int j = 1; j < s.length(); j++) {
                String sub = s.substring(0, j);
                if (sub.equals(s.substring(j, 2 * j))) {
                    System.out.println("#" + i + " " + sub.length());
                    break;
                }
            }

        }
    }
}
