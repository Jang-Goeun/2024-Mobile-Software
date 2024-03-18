package ddwu.mobile.week03

/*
fun funName(num : Int) : String {
    println(num)
    return "return"
}
*/

/* 람다함수
    //funName(1)

    val lambda = {num : Int ->
        println(num)
        "return" // 람다함수의 return 값임. lambda 변수에 대입되는 값이 아님 주의!!
    }
    // 람다 함수 -> 지역변수로 사용된다.

    val noParam : (Int, String) -> Unit = {num : Int, str : String ->
        println(10)
    }
    // 함수의 데이터형 표현 방식 => (매개변수타입) -> 반환타입
    // 만약에 반환값이 없을 경우 Unit을 쓰면 됨

    val noParam2 : (Int) -> Unit = {println(it)}
    //매개변수가 1개일 때에는 변수 선언 없이 미리 약속된 it이라는 변수를 사용하면 된다.

    println(noParam(10, "test"))
    println(lambda(10))

    //실행 시 출력 내용은 아래와 같다.
    //10
    //return
*/

/* 고차함수
val nameFunc : () -> Unit = {
        println("SomSom!")
    }
    val subjectFunc : () -> Unit = {
        val subjectName = "Mobile software"
        println(subjectName)
    }

    // 고차함수: 반환값과 매개변수가 없는 함수가 argFunc에 대입, String형식의 매개변수를 받고 return값이 없는 람다함수를 반환한다.
    fun higherOrderFunc (argFunc : () -> Unit) : (String) -> Unit {
        println("Dept: Computer")
        argFunc()   //nameFunc 함수의 코드 자체가 이 위치에 들어오게 됨, 매개변수에 따라 유연하게 코드가 변경될 수 있음

        return { grade: String -> println(grade)}
    }

    var returnFunc: (String) -> Unit = higherOrderFunc(nameFunc)

    returnFunc("A+")
 */

fun main() {
    var str: String? = null
    println(str?.length)
    //null

    str = "test"
    println(str?.length)
    //4

    str = "Mobile"
    println(str?.length ?: 0)
    //6
    
    str = null
    println(str?.length ?: 0)  //엘비스 연산자: null이 아닐 때 왼쪽 값이 출력되고, null일 때 오른쪽 값이 사용됨
    //0

    //println(str!!.length ?: 0) !!의 경우 NullPointerException 발생 -> 예외처리 필요
}


