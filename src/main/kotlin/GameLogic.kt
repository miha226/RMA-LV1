class GameLogic(
    val scoreRules: ScoreRules=ScoreRules(),
    val hand: Hand = Hand(),
    val scoreBoard: ScoreBoard = ScoreBoard()
) {

    fun decisions(){
        print("Write order: ")
        val letters = readLine()
        when (letters){
            "roll" -> roll()
            "score" -> checkScore()
            "finish" -> finish()
            "help" -> help()
        }
    }
    fun help() {
        println("Write help to see all functions")
        println("Write roll to roll dice")
        println("Write score to check score")
        println("Write finish to stop playing and show final score")
        decisions()
    }

    fun finish() {
        print("Result is: ")
        println(scoreBoard.totalResult())
    }

    fun rollHelp(){
        println("You are throwing dies 3 times")
        println("After each throw you can lock die writing b or unlock writing a")
        println("If you want to stop write 'stop'")
    }
    fun roll(){
        println("You can write help to see rules of dice rolling")
        var numberOfRolls=3
        hand.roll()
        do {
            val letters = readLine()!!.split(" ").map { it }
            if(letters.contains("stop")) numberOfRolls=0
            else if(letters.contains("help")) rollHelp()
            else {
                numberOfRolls--
                println(letters)
                hand.lockDice(letters)
                hand.roll()
            }
        }while(numberOfRolls>1)
        insertScore()
    }

    fun insertScore(){
        println("Write key of score that you want to put in scoreboard")
        var results = mutableMapOf("largeStraight" to hand.checkNumbers(scoreRules.largeStraight),
            "yahtzee" to hand.checkNumbers (scoreRules.yahtzee), "3kind" to hand.checkNumbers (scoreRules.threeOfAKind),
            "4kind" to hand.checkNumbers (scoreRules.fourOFAKind), "1" to hand.checkNumbers (scoreRules.sumOfOnes),
            "2" to hand.checkNumbers (scoreRules.sumOfTwos), "3" to hand.checkNumbers (scoreRules.sumOfThrees),
            "4" to hand.checkNumbers (scoreRules.sumOfFours), "5" to hand.checkNumbers (scoreRules.sumOfFives),
            "6" to hand.checkNumbers (scoreRules.sumOfSix)).filter { it.value>0 }
        println(results)
        var inserted = false
        do {
            val letters = readLine().toString()
            if (results.containsKey(letters)){
                var x : Int? = 0
                x = scoreBoard.score[letters]
                x = x?.plus(results[letters]!!)
                scoreBoard.score[letters] = x!!
                inserted=true
            }
            else{println("That key does not exist")}
        }while (inserted==false)
        println("Score is added to scoreboard")
        decisions()
    }

    fun checkScore(){println(scoreBoard.score); decisions()}

}