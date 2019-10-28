// :o doesn't compile val str: String = null
var str: String? = null
val strImmutable: String? = null

fun main() {
    // println(str.length)
    println(str?.length)
    println(str?.length ?: 0)
    // will crash println(str!!.length)
    println(getTranslations()["four"])

    if (strImmutable != null) {
        val x = strImmutable.length * 2
    }

//    doesn't compile
//    if (str != null) {
//        val x = str.length * 2
//    }

    str?.let { str ->
        val x = str.length * 2
    }

    // can also turn stuff into null conditionally!


}

fun getTranslations() = mapOf("one" to "ichi", "two" to "ni", "three" to "san")