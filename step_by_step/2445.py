#별 찍기 -8

n=int(input())

for i in range(n):
  star='*'*(i+1)
  space=' '*(2*n-(2*i+2))
  print(star+space+star)
for i in range(n):
  star='*'*(n-i-1)
  space=' '*(2*(i+1))
  print(star+space+star)
