#대회 인턴
#Greedy

N, M, K = map(int, input().split())

for i in range(K):  
  if N//2 >= M :
    N=N-1
  else:
    M=M-1

print(min(N//2,M))
