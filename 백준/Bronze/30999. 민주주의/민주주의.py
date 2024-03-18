n, m = map(int, input().split())
ans = 0
for _ in range(n):
    if input().count('O') >= m/2:
        ans += 1
print(ans)