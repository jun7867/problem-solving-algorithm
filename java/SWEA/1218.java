package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine());
			String s=br.readLine();
			Stack<Character> stack=new Stack<Character>();
			boolean isValid=true;
			for(int i=0;i<s.length();i++) {
				Character ch=s.charAt(i);
				if(ch=='(' || ch=='{' || ch=='<' || ch=='[') {
					stack.push(ch);
				} else {
					if(ch==')') {
						if(stack.isEmpty() || stack.peek()!='(') {
							isValid=false;
							break;
						} 
						stack.pop();
					} else if(ch==']') {
						if(stack.isEmpty() || stack.peek()!='[') {
							isValid=false;
							break;
						} 
						stack.pop();
					} else if(ch=='}') {
						if(stack.isEmpty() || stack.peek()!='{') {
							isValid=false;
							break;
						} 
						stack.pop();
					} else if(ch=='>') {
						if(stack.isEmpty() || stack.peek()!='<') {
							isValid=false;
							break;
						} 
						stack.pop();
					}
				}
			}
			if(isValid && stack.size() ==0)
				System.out.printf("#%d "+1+"\n",tc);
			else
				System.out.printf("#%d "+0+"\n",tc);
		}

	}

}

