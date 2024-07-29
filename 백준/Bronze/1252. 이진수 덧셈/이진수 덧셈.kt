fun main() {
    val (a, b) = readLine()!!.split(" ").map{ it.toBigInteger(2) }
    println((a+b).toString(2))
}