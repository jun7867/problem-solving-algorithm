import sys

N=int(sys.stdin.readline())
listN=[]

for i in range(N):
    temp=int(sys.stdin.readline())
    if temp != 0:
        listN.append(temp)
    else:
        listN.pop()

print(sum(listN))

  
