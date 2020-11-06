# WCT1-5

count = 0
n = int(input())

for i in range(1, n + 1):
    if '3' in str(i) or '6' in str(i) or '9' in str(i):
        for j in str(i):
            if j == '3' or j == '6' or j == '9':
                count += 1
print(count)
