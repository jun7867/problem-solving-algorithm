import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
            int hour = h1 + h2;
            if (hour > 12)
                hour -= 12;

            int minute = m1 + m2;
            if (minute > 60) {
                minute -= 60;
                hour += 1;
            }

            System.out.println("#" + t + " " + hour + " " + minute);

        }
    }
}

