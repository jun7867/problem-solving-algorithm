#Funtion 07 - 02 4673
#self number
#python3

def self(num):
    sum=num
    for i in str(num):
        sum+=int(i)
    return sum  # 생성자

all_number_set=set(range(1,10001))
process_number_set=set()

for i in range(1,10001):
    process_number_set.add(self(i))

self=all_number_set-process_number_set
sorted_self=sorted(self)
for i in sorted_self:
    print(i)
