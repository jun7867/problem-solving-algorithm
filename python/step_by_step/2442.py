#별찍기 -5

n=int(input())

for i in range(n):
  space=' ' * (n-i-1)
  star = '*' * (2*i+1)
  print(space+star)

