import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        char[] eight = s.toCharArray();

        for (int i = 0; i < eight.length; i++) {
            int num = eight[i] - '0';
            int divide = 4;
            for (int j = 0; j < 3; j++) {
                int temp = num / divide;
                sb.append(temp);
                num -= temp * divide;
                divide /= 2;
            }
        }
        if (s.equals("0")) {
            System.out.println('0');
        } else {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            System.out.println(sb.toString());
        }

    }
}

