import sys

def roundffo(n):
  return int(n)+1 if n-int(n)>=0.5 else int(n)

n=int(sys.stdin.readline())

nList=[int(sys.stdin.readline()) for _ in range(n)]
nList.sort()

trunMean=round(n*(15/100))

if trunMean !=0:
    del nList[:trunMean]
    del nList[-trunMean:]

if n !=0:
    print(roundffo(sum(nList)/len(nList)))
else: 
    print(0)

