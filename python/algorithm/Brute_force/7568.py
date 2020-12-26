#덩치 brute

N=int(input())
nList=[]

for i in range(N):
	x,y=map(int,input().split())
	nList.append((x,y))

for i in nList:
	rank=1
	for j in nList:
		if i[0] < j[0] and i[1] < j[1]:
			rank+=1
	print(rank,end=" ")

