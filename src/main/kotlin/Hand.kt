class Hand(
    val dice: List<Die> = listOf(Die(),Die(),Die(),Die(),Die()),
    var lockedDice: MutableList<String> = mutableListOf("a","a","a","a","a")
) {
    fun roll(): Unit{
       dice.forEachIndexed { index, die -> (if(lockedDice[index]=="a")die.roll()) }
        println(getDiceNumbers())
    }

    fun getDiceNumbers(): List<Int> {
        return dice.map { it.value }
    }

    fun lockDice(list: List<String>){
        list.forEachIndexed { index, letter -> if(letter.equals("a")||letter.equals("b"))lockedDice.set(index,letter)}
    }

    fun checkNumbers(funct:(List<Int>)->Int): Int{
        return funct(getDiceNumbers())
    }
    fun checkNumbersBool(funct:(List<Int>)->Int): Boolean{
        return funct(getDiceNumbers())>0
    }
}


