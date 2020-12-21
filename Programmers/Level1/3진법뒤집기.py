def solution(n):
    ternary = []
    result = 0
    while n / 3 > 0:
        ternary.append(n % 3)
        n //= 3
    for i in range(len(ternary) - 1, -1, -1):
        result += ternary[-i-1] * (3**i)
    return result
