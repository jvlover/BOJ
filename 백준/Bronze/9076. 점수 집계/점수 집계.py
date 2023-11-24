T = int(input())
for _ in range(T):
    l = sorted(list(map(int, input().split())))
    print("KIN" if l[3]-l[1] >= 4 else sum(l[1:4]))