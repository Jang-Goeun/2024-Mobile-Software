package ddwu.mobile.week03

data class RegData(var year: Int, var month: Int, var day: Int) {
    override fun equals(other: Any?): Boolean {
        return this.year == (other as RegData).year   // 타입변환 필요
    }
}
data class Address(var city: String, var dong: String, var addrNo: String)
fun main() {
    val d1 = RegData(2024, 3, 18)
    val d2 = RegData(2024, 3, 18)

    println(d1.equals(d2))
}
