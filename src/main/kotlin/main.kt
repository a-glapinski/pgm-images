import pgm.*
import kotlin.system.measureTimeMillis

fun main() {
    shapes()
    performanceTest()
    filters()
}

fun performanceTest() {
    val blur = PgmImage.loadFromPgmFile("chessboard.pgm")
    val time = measureTimeMillis { blur.convolute(1000, Filters.blur) }
    println(time)
    blur.saveToFile("chessboard_blur.pgm", 255)
}

fun shapes() {
    val chessboard = Chessboard(1024)
    chessboard.saveToFile("chessboard.pgm", 255)

    val tLetter = TLetter(64)
    tLetter.saveToFile("t_letter.pgm", 255)

    val verticalStripes = VerticalStripes(64)
    verticalStripes.saveToFile("vertical_stripes.pgm", 255)

    val horizontalStripes = HorizontalStripes(64)
    horizontalStripes.saveToFile("horizontal_stripes.pgm", 255)
}

fun filters() {
    val boxBlur = PgmImage.loadFromPgmFile("chessboard.pgm")
    boxBlur.convolute(100, Filters.boxBlur)
    boxBlur.saveToFile("chessboard_box_blur.pgm", 255)

    val sharpen = PgmImage.loadFromPgmFile("chessboard_blur.pgm")
    sharpen.convolute(1, Filters.sharpen)
    sharpen.saveToFile("chessboard_sharpen.pgm", 255)

    val outline = PgmImage.loadFromPgmFile("chessboard.pgm")
    outline.convolute(1, Filters.outline)
    outline.saveToFile("chessboard_outline.pgm", 255)

    val bottomSobel = PgmImage.loadFromPgmFile("chessboard.pgm")
    bottomSobel.convolute(1, Filters.bottomSobel)
    bottomSobel.saveToFile("chessboard_bottom_sobel.pgm", 255)

    val leftSobel = PgmImage.loadFromPgmFile("chessboard.pgm")
    leftSobel.convolute(1, Filters.leftSobel)
    leftSobel.saveToFile("chessboard_left_sobel.pgm", 255)

    val castle = PgmImage.loadFromImage("castle.jpg")
    castle.convolute(1, Filters.outline)
    castle.saveToFile("castle_outline.pgm")

    val castleEmboss = PgmImage.loadFromImage("castle.jpg")
    castleEmboss.convolute(1, Filters.emboss)
    castleEmboss.saveToFile("castle_emboss.pgm")

    val weird = PgmImage.loadFromPgmFile("chessboard_blur.pgm")
    weird.convolute(2, Filters.weird)
    weird.saveToFile("chessboard_weird.pgm", 255)
}