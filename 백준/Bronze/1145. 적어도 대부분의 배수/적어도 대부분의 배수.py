l = list(map(int, input().split()))
ans = min(l)
while 1:
    cnt = 0
    for i in l:
        if not ans%i:
            cnt += 1
    if cnt > 2:
        break
    ans += 1
print(ans)