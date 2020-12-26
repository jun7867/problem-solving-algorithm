#다이얼
#문자열

dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
Alpha = input()
count = 0

for i in range(len(Alpha)):
    for j in dial:
        if Alpha[i] in j:
            count += dial.index(j)+3

print(count)

