fun main(args: Array<String>) {
  val (N, m, M, T, R) = readLine()!!.split(" ").map { it.toInt() }
  var n = m
  var tmp = 0
  var ans = 0

  if (m + T > M) {
      print(-1)
  } else {
      while (tmp < N) {
          if (n+T <= M) {
              n += T
              ++ans
              ++tmp
          } else {
              n = maxOf(n-R, m)
              ++ans
          }
      }
      print(ans)
  }
}