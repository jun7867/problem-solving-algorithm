# 9506 약수들의 합

import sys

while(1):
    n = int(sys.stdin.readline())

    if n == -1:
        break

    nList = []
    for i in range(1, n):
        if n % i == 0:
            nList.append(i)
    if sum(nList) == n:
        a = ""
        for j in range(len(nList)-1):
            a += str(nList[j])+" + "
        a += str(nList[-1])
        print(str(n) + " = " + a)
    else:
        print(str(n)+" is NOT perfect.")

