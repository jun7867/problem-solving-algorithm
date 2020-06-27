#Sorted 사용
#수 정렬하기

N=int(input())
N_list=[]
for i in range(N):
	temp=int(input())
	N_list.append(temp)

sort_N=sorted(N_list)

for i in sort_N:
	print(i)
