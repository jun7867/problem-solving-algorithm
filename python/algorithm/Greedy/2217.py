#로프
#로직을 이해해야함(무게가 제일 작은거 * 개수) 

N = int(input())
W=[]
maxW=[]

for i in range(N):
  weight=int(input())
  W.append(weight)

W=sorted(W,reverse=True)

for i in range(N):
  maxW.append(W[i]*(i+1))

print(max(maxW))
