#노래 악보
N,Q=map(int,input().split())
NList = [int(input()) for _ in range(N)]
QList = [int(input()) for _ in range(Q)]

musicList=[]
count=1
for i in NList:
  for _ in range(i):
    musicList.append(count)
  count+=1

for i in QList:
	print(musicList[i])
