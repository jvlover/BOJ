idx, ans = 0, 0
for i in range(1, 6):
    temp = sum(map(int, input().split()))
    if ans < temp:
        idx = i
        ans = temp
print(idx, ans)