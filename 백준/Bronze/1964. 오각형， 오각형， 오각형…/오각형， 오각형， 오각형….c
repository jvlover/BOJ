#include <stdio.h>
int main() {
    int n;
    scanf("%d", &n);
    long long ans = 5;
    long long p = 7;
    for (int i = 1; i < n; i++)
    {
        ans += p;
        ans %= 45678;
        p += 3;
    }
    printf("%d", ans);
    return 0;
}