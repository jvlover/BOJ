import sys
input = sys.stdin.readline
n = int(input())
res = 0
for _ in range(n):
    l = list(map(int, input().split()))
    res = max(res, max(l[:2])+sum(sorted(l[2:])[3:]))
print(res)