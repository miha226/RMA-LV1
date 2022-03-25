class ScoreRules {

    val largeStraight : (List<Int>) -> Int = {numbers:List<Int> ->
        if(numbers.containsAll(listOf(1,2,3,4,5)) || numbers.containsAll(listOf(2,3,4,5,6))) 40 else 0}


    val yahtzee : (List<Int>) -> Int = {numbers -> if(numbers.distinct().size==1) 50 else 0 }


    val threeOfAKind : (List<Int>) -> Int = {numbers ->
        val y = numbers.groupingBy { it }.eachCount()
        if(y.any{it.value==3}){
            if (y.any{it.value==2}) 25 else numbers.sum()
        }
        else 0
    }

    val fourOFAKind : (List<Int>) -> Int = {numbers ->
        val y = numbers.groupingBy { it }.eachCount()
        if(y.any{it.value==4}) numbers.sum() else 0
    }

    val sumOfOnes : (List<Int>) -> Int = {numbers -> numbers.filter { it==1 }.sum()}
    val sumOfTwos : (List<Int>) -> Int = {numbers -> numbers.filter { it==2 }.sum()}
    val sumOfThrees : (List<Int>) -> Int = {numbers -> numbers.filter { it==3 }.sum()}
    val sumOfFours : (List<Int>) -> Int = {numbers -> numbers.filter { it==4 }.sum()}
    val sumOfFives : (List<Int>) -> Int = {numbers -> numbers.filter { it==5 }.sum()}
    val sumOfSix : (List<Int>) -> Int = {numbers -> numbers.filter { it==6 }.sum()}
}