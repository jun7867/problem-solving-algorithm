#10809
#문자열 알파벳 찾기

S=input()
alphabet='abcdefghijklmnopqrstuvwxyz'
dic={}
for i in range(len(S)):
	if S[i] not in dic.keys():
		dic[S[i]]=i	

for i in alphabet:
	if (i in S):
		print(dic[i],end=" ")
	else:
		print("-1",end=" ")
		
	
