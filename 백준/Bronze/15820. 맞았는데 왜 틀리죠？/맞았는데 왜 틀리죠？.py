import sys
input = sys.stdin.readline
s1, s2 = map(int, input().split())
ans = "Accepted"
for _ in range(s1):
    a, b = map(int, input().split())
    if a != b:
        ans = "Wrong Answer"
        break
if ans == "Accepted":
    for _ in range(s2):
        a, b = map(int, input().split())
        if a != b:
            ans = "Why Wrong!!!"
            break
print(ans)