import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        String[] file = new String[N];

        for (int i = 0; i < N; i++) {
            file[i] = sc.next();
        }

        for (int i = 0; i < file[0].length(); i++) {
            char pre = file[0].charAt(i);
            boolean isQ = false;
            for (int j = 1; j < file.length; j++) {
                if (pre != file[j].charAt(i)) {
                    sb.append('?');
                    isQ = true;
                    break;
                }
                pre = file[j].charAt(i);
            }
            if (!isQ) {
                sb.append(pre);
            }
        }
        System.out.println(sb.toString());
    }
}

