package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_남준영 {
	static Stack<Character> opStack;
	static Stack<Integer> numStack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numStack= new Stack<Integer>();
		opStack=new Stack<Character>();
		int T=10;
		for(int tc=1;tc<=T;tc++) {
			br.readLine(); // 의미없는 값
			String str=br.readLine();
			str=changePostfix(str);
			int result= calculate(str);
			System.out.printf("#%d %d\n",tc,result);
			
		}
	}
	// 중위식 -> 후위식 변환.
	static String changePostfix(String str) {
		StringBuilder sb =new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			// 숫자면 그대로 집어넣기
			if(ch >='0' && ch<='9') {
				sb.append(ch);
			}else{
				// 곱하기면 opStack에 추가.
				if(ch=='*')
					opStack.push(ch);
				// + 이면.
				else {
					// opStack에 있는것들 하나씩 붙이기. 
					while(!opStack.isEmpty()) {
						sb.append(opStack.pop());
					}
					// opStack에 + 추가.
					opStack.push(ch);
				}
			}
		}
		// stack에 남은 연산자 추가.
		while(!opStack.isEmpty())
			sb.append(opStack.pop());
		return sb.toString();
	}
	// 후위 표현식 계산.
	static int calculate(String str) {
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch >='0' && ch<='9')
				numStack.push(ch-'0');
			else{ // + or *
				int a=numStack.pop();
				int b=numStack.pop();
				
				if(ch=='+') numStack.push(b+a);
				if(ch=='*') numStack.push(b*a);
			}	
		}
		return numStack.pop();
	}
	
}

