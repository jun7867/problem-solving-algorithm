#단어 공부
#문자열

from collections import Counter

answer=[]
S=input()

S_upper=S.upper()

C=Counter(S_upper)

max_value=max(list(C.values()))

for key in list(C.keys()):
	if C[key] == max_value :
		answer.append(key)
if len(answer) > 1 :
	print('?')
else:
	print(answer[0])	
