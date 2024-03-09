a, b, c, d, e = map(int, input().split())
ans = 4*e-a-b-c-d
print(ans if ans > 0 else 0)