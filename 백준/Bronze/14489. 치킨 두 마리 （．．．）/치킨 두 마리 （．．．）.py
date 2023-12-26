total = sum(map(int, input().split()))
price = int(input())*2
print(total-price if total >= price else total)