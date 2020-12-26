#Greedy
#30

N= input()
temp=0


if '0' not in N:
  print(-1)
else:
  for i in N:
    temp+=int(i)
  if temp%3 != 0:
    print(-1)
  else:
    print("".join(sorted(N,reverse=True)))
