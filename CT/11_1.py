s = "baaaa"
n = len(s)
count = 0
countA = 0

if 'aaa' in s:
    return -1
for i in range(n):
    if s[i] == 'a':
        countA += 1
return (n+1-countA)*2 - countA

