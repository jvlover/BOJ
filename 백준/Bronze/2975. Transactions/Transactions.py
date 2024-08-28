import sys
input = sys.stdin.readline
while 1:
    l = input().strip().split()
    a, b, c = int(l[0]), l[1], int(l[2])
    if a == 0 and b == 'W' and c == 0: break
    if b == 'W':
        ans = a-c
        print(ans if ans >= -200 else 'Not allowed')
    else:
        print(a+c)
        