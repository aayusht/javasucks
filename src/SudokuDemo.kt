val board = arrayOf(
    intArrayOf(6, 3, 9, 5, 7, 4, 1, 8, 2),
    intArrayOf(5, 4, 1, 8, 2, 9, 3, 7, 6),
    intArrayOf(7, 8, 2, 6, 1, 3, 9, 5, 4),
    intArrayOf(1, 9, 8, 4, 6, 7, 5, 2, 3),
    intArrayOf(3, 6, 5, 9, 8, 2, 4, 1, 7),
    intArrayOf(4, 2, 7, 1, 3, 5, 8, 6, 9),
    intArrayOf(9, 5, 6, 7, 4, 8, 2, 3, 1),
    intArrayOf(8, 1, 3, 2, 9, 6, 7, 4, 5),
    intArrayOf(2, 7, 4, 3, 5, 1, 6, 9, 8)
)

fun main() {
    println(verify(board))
}

fun verify(rows: Array<IntArray>) = verifyRows(rows) && verifyColumns(rows) && verifySquares(rows)

fun verifyNine(nineDigits: IntArray) = nineDigits.toSet().size == 9

fun verifyRows(rows: Array<IntArray>) = rows.all(::verifyNine)

fun verifyColumns(rows: Array<IntArray>) = Array(9) { i -> rows.getColumn(i) }.all(::verifyNine)

fun Array<IntArray>.getColumn(i: Int) = map { row -> row[i] }.toIntArray()

fun verifySquares(rows: Array<IntArray>): Boolean {
    val indices = (0 until 9 step 3) zip (0 until 9 step 3)
    return indices.map { (x, y) -> rows.getSquare(x, y) }.all(::verifyNine)
}

fun Array<IntArray>.getSquare(x: Int, y: Int) = intArrayOf(
    this[x][y], this[x][y + 1], this[x][y + 2],
    this[x + 1][y], this[x + 1][y + 1], this[x + 1][y + 2],
    this[x + 2][y], this[x + 2][y + 1], this[x + 2][y + 2]
)
