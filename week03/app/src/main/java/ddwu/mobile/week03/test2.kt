package ddwu.mobile.week03

class MyClass (){
    //위처럼 멤버변수를 만들 때에는 객체가 생성될 때 필수로 멤버변수가 생성되야 한다는 것을 의미함
    //()내용이 있다면 주생성자를 사용한다고 생각하면 됨
    //()가 없지만 init블록있다면 매개변수 없는 객체를 만들겠다는 소리임
    //멤버변수  -> 초기화가 만드시 이루어져야함(단, 생성자가 있으면 초기화 생략 가능)
    //주생성자의 코드는 init{}블록에서 작성함
    //부생성자 -> 생성자를 만들었기 때문에 디폴트 생성자 사용 못함
    //var dept: String = "test"

    init {
        println("Main class")
    }

    constructor(dept: String): this() {  //보조생성자는 반드시 :this()를 사용하여 주생성자를 호출해야함
        println(dept)
    }


    fun getDept() {  //멤버함수
//        println(dept)
    }
}

fun main() {
    val myObject : MyClass = MyClass("computer") //객체생성
    //myObject.getDept()
}