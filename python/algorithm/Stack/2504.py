#2504 괄호
#Tip: Stack
import sys

#불가능한 경우 탐색
def check_brakcets(ss):
    stack = []
    for s in ss:
        if s == '(' or s == '[':
            stack.append(s)
        elif s == ')' and stack:
            if stack[-1] == '(':
                stack.pop()
            else:
                stack.append(s)
        elif s == ']' and stack:
            if stack[-1] == '[':
                stack.pop()
            else:
                stack.append(s)
        else:
            stack.append(s)
    if stack:
        return False
    #짝이 다 맞으면 가능한 경우라 Stack이 비어져 있음.
    else:
        return True

#점수 계산
def sol(ss):
    stack = []
    for s in ss:
        
        if s == '(' or s == '[':
            stack.append(s)
        elif s == ')':
            if stack[-1] == '(':
                stack[-1] = 2
            #이부분이 핵심
            else:
                tmp = 0
                #끝에서부터 0까지
                for i in range(len(stack) - 1, -1, -1):
                    if stack[i] == '(':
                        stack[-1] = tmp * 2
                        break
                    else:
                        tmp += stack[i]
                        stack.pop()
        elif s == ']':
            if stack[-1] == '[':
                stack[-1] = 3
            else:
                tmp = 0
                for i in range(len(stack) - 1, -1, -1):
                    if stack[i] == '[':
                        stack[-1] = tmp * 3
                        break
                    else:
                        tmp += stack[i]
                        stack.pop()
    return sum(stack)

brackets = sys.stdin.readline().strip()
if check_brakcets(brackets) == False:
    print(0)
else:
    print(sol(brackets))
