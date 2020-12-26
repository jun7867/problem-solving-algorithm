import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < croatia.length; i++) {
            if (s.contains(croatia[i])) {
                s = s.replaceAll(croatia[i], "*");
            }
        }

        System.out.println(s.length());

    }
}
