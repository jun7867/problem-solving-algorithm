import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();// 초기값 지정
        map.put('A', 2);
        map.put('B', 2);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 3);
        map.put('F', 3);
        map.put('G', 4);
        map.put('H', 4);
        map.put('I', 4);
        map.put('J', 5);
        map.put('K', 5);
        map.put('L', 5);
        map.put('M', 6);
        map.put('N', 6);
        map.put('O', 6);
        map.put('P', 7);
        map.put('Q', 7);
        map.put('R', 7);
        map.put('S', 7);
        map.put('T', 8);
        map.put('U', 8);
        map.put('V', 8);
        map.put('W', 9);
        map.put('X', 9);
        map.put('Y', 9);
        map.put('Z', 9);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count += map.get(ch) + 1;
        }
        System.out.println(count);

    }
}
