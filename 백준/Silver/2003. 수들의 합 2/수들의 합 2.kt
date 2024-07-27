fun main() {
    val (n, m) = readLine()!!.split(" ").map {it.toInt()}
    val arr = readLine()!!.split(" ").map {it.toInt()}
    var cnt = 0
    var left = 0
    var right = 1
    var sum = arr[0]
    while (true) {
        if (sum >= m) {
            if (sum == m) cnt++
            sum -= arr[left++]
        } else {
            if (right == n) break
            sum += arr[right++]
        }
    }
    print(cnt)
}