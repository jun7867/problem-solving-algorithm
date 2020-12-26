#크로아티아 알파벳
#문자열

S=input()
Croatia=['c=','c-','dz=','d-','lj','nj','s=','z=']
count=0

for i in Croatia:
	S=S.replace(i,'*')
print(len(S))	
