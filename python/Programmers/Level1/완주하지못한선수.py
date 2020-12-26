# 완주하지 못한 선수
# Programmers
from collections import Counter

participant = ["leo", "kiki", "eden"]
completion = ["eden", "kiki"]

CP = Counter(participant)
CC = Counter(completion)
for N, C in CP:
    if CC[N] == 0 or CC[N] != C:
        print(N)
