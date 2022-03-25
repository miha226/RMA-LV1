import kotlin.random.Random
class Die(
    var value: Int =1
) {
    fun roll(): Unit {value =Random.nextInt(1,6)}
}