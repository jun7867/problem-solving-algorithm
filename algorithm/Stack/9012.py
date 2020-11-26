# 9012 괄호

import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    s = input().strip()
    stack = []
    isVPS = True
    for i in range(len(s)):
        if s[i] == '(':
            stack.append('(')
        elif s[i] == ')' and stack:
            stack.pop()
        else:
            isVPS = False
            break
    if isVPS and not stack:
        print('YES')
    else:
        print('NO')

