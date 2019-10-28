fun main() {
    println(bar(6, 6))
    println(bar(x = 6, y = 6))
    println(barA(6, 6))
    println(barB(6, 6))
    println(barC(6, 6))
    println(barD(6, 6))
    println(barD(6))
    println(6.barE(6))
    println(6 barF 6)
    println(barG(0f) is Float)
    println(barG(0L) is Long)
    println("42" / "6")
    println(barH(6, 6))
    println(barI(6, 6))
    println(barJ(6))
    val x: Int = _run(mutableListOf("a", "b", "c")) { list ->
        list.reversed().forEach { println(it) }
        list.size
    }

    _with(mutableListOf("a", "b", "c")) {
        this.reversed().forEach { println(it) }
    }
}

fun bar(x: Int, y: Int): Int {
    return x * y + y
}

fun barA(x: Int, y: Int): Int = x * y + y

fun barB(x: Int, y: Int): Int = x * y + y

fun barC(x: Int, y: Int) = x * y + y

fun barD(x: Int, y: Int = 1) = x * y + y

fun Int.barE(y: Int) = this * y + y

infix fun Int.barF(y: Int) = this * y + y

fun <T : Number> barG(x: T): T = x

operator fun String.div(y: String) = this.toFloat() / y.toFloat()

val barH: (Int, Int) -> Int = { x, y -> x * y + y }

val barI = { x: Int, y: Int -> x * y + y }

val barJ: (Int) -> Int = { it * 2 + 2 }

fun <T, V> _run(arg: T, f: (T) -> V) = f(arg)

fun <T> _with(arg: T, f: T.() -> Unit) {
    arg.f()
}
