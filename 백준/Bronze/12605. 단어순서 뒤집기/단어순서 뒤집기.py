import sys
input = sys.stdin.readline
n = int(input())
for i in range(1, n+1):
    s = " ".join(input().split()[::-1])
    print(f"Case #{i}: {s}")