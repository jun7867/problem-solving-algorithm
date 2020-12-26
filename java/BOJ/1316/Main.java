import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int Nocount = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            sb.delete(0, sb.length()); // StringBuilder 초기화
            for (int j = 0; j < s.length(); j++) {
                if (sb.toString().contains(String.valueOf(s.charAt(j)))) {
                    Nocount++;
                    break;
                }
                if (j != s.length() - 1 && s.charAt(j) != s.charAt(j + 1)) {
                    sb.append(s.charAt(j));
                }
            }
        }
        System.out.println(N - Nocount);
    }
}
