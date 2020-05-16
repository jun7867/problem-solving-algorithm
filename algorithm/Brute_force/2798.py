#brute-force Search 
#블랙잭

N, M=map(int,input().split())
card=list(map(int,input().split()))
sum=0
max_sum=0

for i in range(0,N-2):
        for j in range(i+1,N-1):
                for k in range(j+1,N):
                        if card[i]+card[j]+card[k] > M:
                                continue
                        else:
                                max_sum=max(max_sum,card[i]+card[j]+card[k])

print(max_sum)	

