import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch - 'a' < 0) {
                arr[ch - 'a' + 32] += 1;
            } else {
                arr[ch - 'a'] += 1;
            }
        }
        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 65); // 대문자로 출력해야하므로 65를 더해준다.
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }

}
