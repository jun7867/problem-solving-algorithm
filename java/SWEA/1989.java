import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String str = sc.next();
            boolean isPalind = true;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    isPalind = false;
                    break;
                }
            }

            if (isPalind) {
                System.out.println("#" + t + " 1");
            } else {
                System.out.println("#" + t + " 0");
            }

        }
    }
}

