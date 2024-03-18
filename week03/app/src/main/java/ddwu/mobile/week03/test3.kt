package ddwu.mobile.week03

open class SuperClass {  // 부모 클래스 앞에 open 작성해야함
    init {
        println("Super class")
    }
}

class SubClass : SuperClass() { // 상위 클래스의 생성자 호출 필요
    init {
        println("Sub class")
    }
}