input()
v = 0
for i in map(int, input().split()):
    v = i+v-i*v/100
    print(v)