N = int(input())
l = list(map(int, input().split()))
ans = 0
for i in l:
    flag = 0
    if i == 1: 
        continue
    for j in range(2, i):
        if i % j == 0:
            flag = 1
    if not flag:
        ans += 1
print(ans)