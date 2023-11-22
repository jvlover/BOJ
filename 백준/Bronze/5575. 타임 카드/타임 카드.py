for _ in range(3):
    l = list(map(int, input().split()))
    t = (3600*l[3]+60*l[4]+l[5])-(3600*l[0]+60*l[1]+l[2])
    print(t//3600, t%3600//60, t%60)