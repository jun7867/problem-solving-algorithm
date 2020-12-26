n, w = map(int, input().split())
price = []
num = 0
for _ in range(n):
    price.append(int(input()))

for i in range(n-1):
    if price[i] < price[i+1]:
        if w//price[i] > 0:
            num = w//price[i]
            w = w-(num*price[i])
    elif price[i] > price[i-1]:
        w += num*price[i]
        num = 0
if num > 0:
    w += num*price[-1]
print(w)

