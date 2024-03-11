package ddwu.mobile.week02.kotlintest

fun main(){
    println("점수 입력: ")
    val socres = Array<Int> (5){ readLine()!!.toInt() } // Array<Int> == IntArray
    var sum = 0

    for (socre in socres) { // score는 for문 안에서만 사용되는 변수로 선언하지 않고 사용 가능함
        sum += socre
    }

    println("총합: $sum  평균: ${sum / 5}")
}