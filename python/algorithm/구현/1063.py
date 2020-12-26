#시물레이션 
#1063 킹
def Move(split,key,flag,name) :
  if key =='R' and ord(split[0]) <72:
    split[0]=chr(ord(split[0]) +1)
  elif key == 'L' and ord(split[0]) >65:
    split[0]=chr(ord(split[0]) -1)
  elif key == 'B' and int(split[1]) > 1:
    split[1] =str(int(split[1])-1)
  elif key == 'T' and int(split[1]) < 8:
    split[1] =str(int(split[1])+1)
  elif key == "RT" and ord(split[0]) <72 and int(split[1]) < 8:
    split[0]=chr(ord(split[0]) +1)
    split[1] =str(int(split[1])+1)
  elif key == "LT" and ord(split[0]) >65 and int(split[1]) < 8:
    split[0]=chr(ord(split[0]) -1)
    split[1] =str(int(split[1])+1)
  elif key == "RB" and ord(split[0]) <72 and int(split[1]) > 1:
    split[0]=chr(ord(split[0]) +1)
    split[1] =str(int(split[1])-1)
  elif key == "LB" and ord(split[0]) >65 and int(split[1]) > 8:
    split[0]=chr(ord(split[0]) -1)
    split[1] =str(int(split[1])-1)
  else:
    if(name =="stone"):
      flag=1
  
  return split,flag

king,stone,n=input().split()
king_split=list(king)
stone_split=list(stone)

for _ in range(int(n)):
  key=(input())
  flag=0
  temp_k=[king_split[0],king_split[1]]
  temp_s=[stone_split[0],stone_split[1]]
  king_split,flag=Move(king_split,key,flag,"king")

  if "".join(king_split) == "".join(stone_split):
    stone_split,flag=Move(stone_split,key,flag,"stone")
    if flag == 1 :
      king_split=temp_k
      stone_split=temp_s
  # print("지금 위치 !","".join(king_split), "".join(stone_split))


print("".join(king_split))
print("".join(stone_split))



