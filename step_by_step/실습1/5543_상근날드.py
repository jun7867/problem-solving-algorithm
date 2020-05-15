#상근날드 if문 문제

buger=[0,0,0]
drink=[0,0]

for i in range(len(buger)):
	buger[i]=int(input())
for i in range(len(drink)):
	drink[i]=int(input())

set_price=min(buger)+min(drink)-50

print(set_price)

