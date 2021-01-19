
// 15649 N과 M
// 백트랙킹
import java.util.*;

public class Main {
    public static int[] arr;
    public static boolean[] visited;
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N];

        dfs(0);

    }

    static void dfs(int depth) {
        if (depth == M) {
            print();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }

    // 배열 출력
    static void print() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("");
        return;
    }

}

