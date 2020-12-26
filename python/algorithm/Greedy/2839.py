# 설탕 배달
kg=int(input())
count=0

while(kg>0):
  if kg % 5 !=0:
    kg-=3
    count+=1
    if kg <0:
        count=-1
        break
  elif kg % 5 ==0:
    kg-=5
    count+=1
  
print(count)
