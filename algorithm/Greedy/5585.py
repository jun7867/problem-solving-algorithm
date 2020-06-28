#5585 거스름돈
#Greedy Algorithm

N=int(input())

money=1000-N
result=0

result += money // 500
money %=500

result += (money // 100)
money %=100

result += (money // 50)
money %=50

result += (money // 10)
money %=10

result += (money // 5)
money %=5

result += (money // 1)
money %=1
print(result)
