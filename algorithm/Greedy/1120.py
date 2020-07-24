#1120 문자열
#Greedy

A, B=input().split()

N=len(B)-len(A)
cnt_list=[]

for i in range(N+1):
  cnt=0
  for j in range(len(A)):
    if(A[j] !=B[i+j]):
      cnt +=1
  cnt_list.append(cnt)

print(min(cnt_list))



