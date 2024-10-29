import sys
input = sys.stdin.readline
while 1:
    s = input().strip()
    if s == 'CU':
        s = 'see you'
    elif s == ':-)':
        s = 'I’m happy'
    elif s == ':-(':
        s = 'I’m unhappy'
    elif s == ';-)':
        s = 'wink'
    elif s == ':-P':
        s = 'stick out my tongue'
    elif s == '(~.~)':
        s = 'sleepy'
    elif s == 'TA':
        s = 'totally awesome'
    elif s == 'CCC':
        s = 'Canadian Computing Competition'
    elif s == 'CUZ':
        s = 'because'
    elif s == 'TY':
        s = 'thank-you'
    elif s == 'YW':
        s = 'you’re welcome'
    elif s == 'TTYL':
        s = 'talk to you later'
        print(s)
        break
    print(s)