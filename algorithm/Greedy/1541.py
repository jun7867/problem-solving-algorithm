#잃어버린 괄호
#Greedy

string=input()

str_list=[]
num_list=[]
minus=0
temp=[]

str_list=string.split("-")

for i in str_list:
  total=0
  temp=i.split('+')
  for j in temp:
    total+=int(j)
  num_list.append(total)


for i in range(1,len(str_list)):
    minus+=num_list[i]

print(num_list[0]-minus)
