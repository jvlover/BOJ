n, k = map(int, input().split())
print("YES" if n <= sum((i+1)//2 for i in map(int, input().split())) else "NO")