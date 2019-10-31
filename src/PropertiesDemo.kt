import kotlin.math.sqrt

fun main() {

}

class Square(arg: Float, initMode: InitMode) {

    enum class InitMode { SIDE, PERIMITER, AREA }

    var sideLength: Float = 0f

    var area: Float
        get() = sideLength * sideLength
        set(value) {
            sideLength = sqrt(value)
        }

    var perimeter: Float
        get() = sideLength * 4
        set(value) {
            sideLength = value / 4
        }

    init {
        when (initMode) {
            InitMode.SIDE -> sideLength = arg
            InitMode.PERIMITER -> perimeter = arg
            InitMode.AREA -> area = arg
        }
    }
}