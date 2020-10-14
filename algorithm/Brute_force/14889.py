# start link 14889
# Bruete force

from itertools import combinations
import sys


N= int(sys.stdin.readline())
table = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
ans=sys.maxsize

members=combinations(range(N),N//2)

for member in members:
    a=set(member)
    b = list(set(range(N)) - a)
    a=list(a)

    a_team,b_team=0,0
    for i in range(N//2 -1):
        for j in range(i+1,N//2):
            a_team+=table[a[i]][a[j]]+table[a[j]][a[i]]
            b_team+=table[b[i]][b[j]]+table[b[j]][b[i]]
    ans=min(ans,abs(b_team-a_team))
print(ans)

