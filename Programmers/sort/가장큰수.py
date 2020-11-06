numbers = [3, 30, 34, 5, 9]
temp = list(map(str, numbers))
temp.sort(key=lambda x: x * 3, reverse=True)
print(temp)
print(*temp, sep='')

