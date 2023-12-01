for _ in range(int(input())):
    N, K = map(int, input().split())
    print(sum(i//K for i in list(map(int, input().split()))))