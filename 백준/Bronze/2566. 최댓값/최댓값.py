arr = [list(map(int, input().split())) for _ in range(9)]
ans = r = c = -1
for i in range(9):
    for j in range(9):
        if arr[i][j] > ans:
            r = i
            c = j
            ans = arr[i][j]
print(ans)
print(r+1, c+1)