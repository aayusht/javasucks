fun main() {
    println(foo1("Hello world!"))
    println(foo1A("Hello world!"))
    println(foo1MAX("Hello world!"))
    println(greeting("Josh Hug"))
    println(getMessage(404))
}

// no semicolons!
fun foo1(argument1: String): Int {
    var length: Int
    length = argument1.length // no primitives
    var sum: Int = 0
    for (i in 0 until length) { // loops in ranges (like python)
        sum += argument1[i].toInt() // no implicit casts
    }
    return sum
}

// type inference and immutable vals
fun foo1A(argument1: String): Int {
    val length = argument1.length // we'll never change this, so why var?
    var sum = 0 // 0 is an int, so sum's an int too
    for (i in 0 until length) {
        sum += argument1[i].toInt()
    }
    return sum
}

// max kotlin!!
fun foo1MAX(argument1: String) = argument1.chars().sum()

// string placeholders
fun greeting(name: String): String {
    return "Hello, $name!"
}

// when statements are inlineable, succint, no breaks
fun getMessage(responseCode: Int): String {
    // didn't have to use a mutable variable!
    val message = when (responseCode) {
        200, 201 -> "u good"
        404 -> "page not found"
        500 -> "rip"
        else -> "Unexpected error"
    }
    return "Response $responseCode: $message"
}

fun bar(): List<String> {
    return listOf("one", "two", "three")
}

fun barMutable(): MutableList<String> {
    return mutableListOf("one", "two", "three")
}

fun printBar() { // no return type btw
//    this won't compile! can't remove, add, or replace anything in immutable list
//    val strings = bar()
//    strings.clear()
//    strings.add("four")

    val strings = barMutable()
    strings.clear()
    strings.add("four")
    println(strings[0])
}
