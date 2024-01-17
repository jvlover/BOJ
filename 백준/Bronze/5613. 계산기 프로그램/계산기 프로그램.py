ans, temp = '', ''
while 1:
    s = input()
    if s == '=':
        break
    elif s.isdigit():
        ans = eval(str(ans)+temp+s)
    else:
        if s == '/':
            temp = '//'
        else:
            temp = s
print(ans)