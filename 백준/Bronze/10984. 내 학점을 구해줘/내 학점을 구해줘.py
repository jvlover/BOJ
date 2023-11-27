for _ in range(int(input())):
    sum_c = sum_g = 0
    for i in range(int(input())):
        c, g = map(float, input().split())
        sum_c += c
        sum_g += c*g
    print('%d %.1f'%(sum_c, sum_g/sum_c))