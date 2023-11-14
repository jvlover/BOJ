c, k, p = map(int, input().split())
print(sum(k*n+p*n**2 for n in range(1, c+1)))