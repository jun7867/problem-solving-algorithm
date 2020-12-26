#분해합

N=str(input())
list_M=[0]

for i in range(int(N)):
	M=sum(map(int,str(i)))+int(i)
	if M==int(N):
		list_M.append(i)
sorted(list_M)
if len(list_M)==1 :  # 추가된게 없을때 == 생성자가 없을때 0 출력
	print(list_M[0])
else:
	print(list_M[1]) # 생성자가 있을때 sorted 후 0제외 첫번째꺼
		
		

