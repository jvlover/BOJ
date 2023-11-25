n = int(input())
is_odd = input() == 'annyong'
k = int(input())
f = k if k%2 == is_odd else k-1
print(f if f else 2)