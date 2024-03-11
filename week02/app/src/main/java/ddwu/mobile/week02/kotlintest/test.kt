package ddwu.mobile.week02.kotlintest

lateinit var data01 : String
val data02 : Int by lazy {
    println("val init")
    1234
}
fun main() {
    data01 = "Mobile"
    println("data01: $data01 data02: $data02")
}