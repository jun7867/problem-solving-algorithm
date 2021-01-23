import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.next();
        for (int i = 0; i < str.length() % 3; i++) {
            str = '0' + str;
        }
        for (int i = 0; i < str.length() / 3; i++) {
            String temp = str.substring(3 * i, 3 * (i + 1));
            int result = 0;
            int n = 4;
            for (int j = 0; j < 3; j++) {
                result += n * (temp.charAt(j) - '0');
                n /= 2;
            }
            sb.append(result);
        }
        System.out.println(sb.toString());
    }
}

