class ScoreBoard(
    var score: MutableMap<String, Int> = mutableMapOf("largeStraight" to 0, "yahtzee" to 0, "3kind" to 0,
        "4kind" to 0, "1" to 0, "2" to 0, "3" to 0, "4" to 0, "5" to 0, "6" to 0)
) {
    fun totalResult() : Int = score.values.sum()


}