for _ in range(int(input())):
    r, e, c = map(int, input().split())
    n = e-c
    if n < r:
        print('do not advertise')
    elif n == r:
        print('does not matter')
    else:
        print('advertise')