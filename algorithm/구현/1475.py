N=list(input())

numList=['0','1','2','3','4','5','6','7','8','9']
count=1
for i in N:
 
  if i in numList:
    numList.remove(i)

  else:
    if i =='6' and '9' in numList:
      numList.remove('9')
    elif i=='9' and '6' in numList:
      numList.remove('6')
    else:
      count+=1
      for j in range(10):
        numList.append(str(j))
      numList.remove(i)

print(count)


