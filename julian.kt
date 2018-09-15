fun main(args: Array<String>) {
    val JD = 2448448.5 + 10000
    val Z = Math.floor(JD + 0.5).toInt()
    val F = JD + 0.5 - Z
    val A = if (Z < 2299161) {
        Z
    } else {
        val a = Math.floor((Z - 1867216.25) / 36524.25).toInt()
        Z + 1 + a - a / 4
    }
    val B = A + 1524
    val C = ((B - 122.1) / 365.25).toInt()
    val D = (365.25 * C).toInt()
    val E = Math.floor((B - D) / 30.6001).toInt()

    val d = B - D - Math.floor(30.6001 * E).toInt() + F
    val m = if (E < 14) E - 1 else E - 13
    val y = if (m > 2) C - 4716 else C - 4715
    println("${y}-${m}-${d}")
}

fun toJulian() {
    var y = 1954
    var m = 6
    val d = 30
    val hours = 0
    val minutes = 0
    val sec = 0
    if (m < 3) {
        y -= 1
        m += 12
    }
    val A = Math.ceil(y / 100.0).toInt()
    var B = 0
    if (y > 1582 || (y == 1582 && (m > 10 || (m == 10 || d >= 15)))) {
        B = 2 - A + Math.ceil(A / 4.0).toInt()
    }
    val JD = Math.floor(365.25 * (y + 4716)) + Math.floor(30.6001 * (m + 1)) + d + B - 1524.5 + hours / 24.0 + minutes / 1440.0 + sec / 86400.0
    println(JD)

}