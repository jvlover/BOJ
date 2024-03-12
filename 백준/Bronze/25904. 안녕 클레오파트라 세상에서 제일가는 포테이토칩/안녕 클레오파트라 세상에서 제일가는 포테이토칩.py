N, X = map(int, input().split())
T = list(map(int, input().split()))
flag = 1
while flag:
    for idx, val in enumerate(T):
        if X <= val:
            X += 1
        else:
            print(idx+1)
            flag = 0
            break