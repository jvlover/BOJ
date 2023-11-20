def solution(s):
    answer = 1
    for start in range(len(s)):
        for end in range(len(s), start-1, -1):
            a = s[start:end]
            if(a == a[::-1]):
                answer = max(answer, end-start)
    return answer