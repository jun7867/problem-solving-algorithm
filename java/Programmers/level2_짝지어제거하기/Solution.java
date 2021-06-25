import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        int len= s.length();
        
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        
        if(stack.size() == 0)
            return 1;
        else
            return 0;
        
    }
}
