T = int(input())
for _ in range(T):
    l = [i for i in map(int, input().split()) if i % 2 == 0]
    print(sum(l), min(l))