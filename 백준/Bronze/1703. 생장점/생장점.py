while 1:
    l = list(map(int, input().split()))
    ans = 1
    if not l[0]:
        break
    for i in range(1, len(l), 2):
        ans *= l[i]
        ans -= l[i+1]
    print(ans)