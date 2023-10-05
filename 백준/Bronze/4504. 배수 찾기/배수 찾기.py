n = int(input())
while 1:
    num = int(input())
    if not num: break
    word = 'NOT ' if num % n else ''
    print(f'{num} is {word}a multiple of {n}.')