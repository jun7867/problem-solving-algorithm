import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < moves.length; i++) {
            int m = moves[i];
            for (int j = 0; j < board.length; j++) {
                if (board[j][m - 1] != 0) {
                    if (!stack.empty() && stack.lastElement() == board[j][m - 1]) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.add(board[j][m - 1]);
                    }
                    board[j][m - 1] = 0;
                    break;
                }
            }
        }
        return count;
    }
}
