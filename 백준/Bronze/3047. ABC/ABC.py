arr = sorted(list(map(int, input().split())))
abc = input()
dic = {'A':0, 'B':1, 'C':2}
print(arr[dic[abc[0]]], arr[dic[abc[1]]], arr[dic[abc[2]]])