import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String strN = String.valueOf(i);
            if (strN.contains("3") || strN.contains("6") || strN.contains("9")) {
                while (strN.contains("3") || strN.contains("6") || strN.contains("9")) {
                    if (strN.contains("3")) {
                        strN = strN.replaceFirst("3", "*");
                    } else if (strN.contains("6")) {
                        strN = strN.replaceFirst("6", "*");
                    } else {
                        strN = strN.replaceFirst("9", "*");
                    }
                    System.out.print("-");
                }
            } else {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
