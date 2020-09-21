#10994 별 찍기 - 19
#recursion

def draw_stars(n, idx):
    if n == 1:
        starMap[idx][idx] = '*'
        return ;
    l = 4 * n -3

    #위 아래
    for i in range(idx, l+idx):
        starMap[idx][i] = '*'
        starMap[idx+l-1][i] = '*'

    #양 옆
    for i in range(idx, l+idx):
        starMap[i][idx] = '*'
        starMap[i][idx+l-1] = '*'     
    
    return draw_stars(n-1, idx+2)
    
    
n = int(input())
lens = 4 * n -3

starMap = [[' '] * lens for _ in range(lens)]

draw_stars(n,0)

for i in range(lens):
    for j in range(lens):
        print(starMap[i][j], end="")
    print()
