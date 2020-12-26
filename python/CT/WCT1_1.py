# WCT1-1

money = 50237
m = [50000, 10000, 5000, 1000, 500, 100, 50, 10, 1]
result = []
for i in m:
    if money // i > 0:
        result.append(money // i)
        money -= i * (money // i)
    else:
        result.append(0)
print(result)
