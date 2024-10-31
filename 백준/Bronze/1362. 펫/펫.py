import sys
input = sys.stdin.readline
cnt = 0
while 1:
    cnt += 1
    is_dead = 0
    o, w = map(int, input().split())
    if not o and not w: break
    while 1:
        a, b = input().split()
        b = int(b)
        if a == '#' and not b: break
        if a == 'E':
            w -= b
        else:
            w += b
        if w <= 0:
            is_dead = 1
    print(f'{cnt} ', end='')
    if is_dead:
        print("RIP")
    else:
        print(':-)' if w > o/2 and w < o*2 else ':-(')