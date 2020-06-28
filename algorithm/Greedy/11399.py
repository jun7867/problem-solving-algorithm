#APM
#11399 Greedy

N = int(input())
N_list=[]
sum_N=0

N_list=list(map(int,input().split()))

N_list=sorted(N_list)

for i in range(N):
  sum_N+=sum(N_list[0:i+1])

print(sum_N)


