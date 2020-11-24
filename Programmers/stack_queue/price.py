def solution(prices):
    result = []
    for i in range(len(prices) - 1):
        finish = False
        for j in range(i, len(prices) - 1):
            if prices[i] > prices[j + 1]:
                result.append(j - i + 1)
                finish = True
                break
        if not finish:
            result.append(len(prices) - i - 1)
    result.append(0)
    return result
