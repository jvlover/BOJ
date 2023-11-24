n = int(input())
row = [["" for _ in range(n)] for _ in range(n)]
col = [["" for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j, c in enumerate(input()):
        row[i][j] = col[j][i] = c
print("YNEOS"[row!=col::2])