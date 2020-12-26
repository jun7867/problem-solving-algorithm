#문자열
#상수

A, B = input().split()

A_list=[]
B_list=[]
A_inverse=""
B_inverse=""
for i in range(3):
	A_list.append(A[i:i+1])
	B_list.append(B[i:i+1])

for i in reversed(range(3)):
	A_inverse += A_list[i]
	B_inverse += B_list[i] 

if A_inverse > B_inverse:
	print(A_inverse)
else:
	print(B_inverse)
