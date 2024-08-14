#include <bits/stdc++.h>
using namespace std;
int main() {
    int h, m, s;
    scanf("%d:%d:%d", &h, &m, &s);
    int curT = 3600*h+60*m+s;
    scanf("%d:%d:%d", &h, &m, &s);
    int startT = 3600*h+60*m+s;
    if (startT < curT) startT += 86400;
    int ans = startT-curT;
    h = ans/3600;
    ans %= 3600;
    m = ans/60;
    ans %= 60;
    s = ans;
    printf("%02d:%02d:%02d", h, m, s);
}