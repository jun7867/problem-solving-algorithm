#Greedy
#동전 0
N , K = map(int,input().split())
N_list=[]
result=0

for i in range(N):
    temp=int(input())
    N_list.append(temp)



for i in range(N):
    if N_list[i] >= K:
      break

for j in range(i,-1,-1):
    result += K // N_list[j]
    K %=N_list[j]

print(result)

