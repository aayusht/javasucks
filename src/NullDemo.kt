// :o doesn't compile val str: String = null
var str: String? = null

fun main() {
    // println(str.length)
    println(str?.length)
    println(str?.length ?: 0)
    // will crash println(str!!.length)
    println(getTranslations()["four"] ?: "Translation not found")
}

// you can turn stuff from null to not null
fun smartCastDemo() {
    if (str != null) {
        // val x = str.length doesn't compile!!
        // str is still a String?
    }

    str?.let { str -> val x = str.length }

    val str = str
    if (str != null) {
        val x = str.length // smart casting
        // str was a String? but is now a String
    }
}

// you can turn stuff from not null to null
fun getStringOrNullIfEmpty(s: String?) = s?.takeIf { s.isNotEmpty() }

fun getStringOrNullIfEmptyB(s: String?) = s?.takeUnless { s.isEmpty() }

fun getTranslations() = mapOf("one" to "ichi", "two" to "ni", "three" to "san")
