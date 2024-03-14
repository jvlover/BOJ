input()
y = m = 0
for i in map(int, input().split()):
    y += (i//30+1)*10
    m += (i//60+1)*15
if y > m:
    print('M', m)
elif y == m:
    print('Y', 'M', y)
else:
    print('Y', y)