j, n = map(int, input().split())
ans = 0
for _ in range(n):
    total = 0
    for s in input():
        if s.isupper():
            total += 4
        elif s.islower() or s.isdigit():
            total += 2
        else:
            total += 1
    if total <= j:
        ans += 1
print(ans)