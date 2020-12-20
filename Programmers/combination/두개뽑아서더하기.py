# 두 개 뽑아서 더하기
# Programmers
from itertools import combinations

def solution(numbers):
    combi = combinations(numbers, 2)
    result = []
    for a, b in combi:
        result.append(a + b)
    result = list(set(result))
    result.sort()
    
    return result
