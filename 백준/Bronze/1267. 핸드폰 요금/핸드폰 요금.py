input()
y, m = 0, 0
for i in list(map(int, input().split())):
    y += (i//30+1)*10
    m += (i//60+1)*15
if y > m:
    print(f'M {m}')
elif y == m:
    print(f'Y M {m}')
else:
    print(f'Y {y}')