package ddwu.mobile.week03

data class Subject (val title: String, var credit: Int)
//주생성자 사용, 멤버변수 2개, data는 값 자체를 보관하는 역할
//data는 멤버변수를 적절히 조합하여 출력해주는 toString() 역할과 비교함수 equals()함수를 정의해줌

fun main() {
    val sub1 = Subject("mobile", 3)
    val sub2 = Subject("mobile", 3)

    println(Subject("mobile", 3))
    println(sub1 == sub2) // 메모리 주소 비교
    println(sub1.equals(sub2))  // 저장된 값(모든 멤버변수) 비교
}