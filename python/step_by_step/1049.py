#기타줄 수학
N,M=map(int,input().split())

package=[]
piece=[]
for _ in range(M):
    a,b=map(int,input().split())
    package.append(a)
    piece.append(b)

package.sort()
piece.sort()
count=N//6
rem=N%6
anwser=0

if package[0] > 6 * piece[0]:
  package[0]=6*piece[0]

if rem * piece[0] > package[0]:
  anwser=(count+1)*package[0]
else:
  anwser=count*package[0]+rem*piece[0]

print(anwser)


