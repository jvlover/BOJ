for _ in range(int(input())):
    n = int(input())
    rooms = [0]*(n+1)
    for i in range(1, n+1):
        for j in range(i, n+1, i):
            if rooms[j]:
                rooms[j] = 0
            else:
                rooms[j] = 1
    print(sum(rooms))