# WCT1-3

word = "I love you"
result = ""
# A = 65 , B = 66 ,.. N = 78 => sum 155
# Z = 90 , Y = 89... M = 77
# A~z = 65 ~122 => sum 97+122 =>219

for i in word:
    if ord(i) >= 65 and ord(i) <= 122:
        if ord(i) < 97:  #대문자
            result += chr(155 - ord(i))
        else:
            result += chr(219 - ord(i))
    else:
        result += i
print(result)

