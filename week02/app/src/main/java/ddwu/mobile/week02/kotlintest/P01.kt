package ddwu.mobile.week02.kotlintest

fun main() {
    print("키를 입력하시오. (cm 단위): ")
    var h = readLine()!!.toInt();

    print("몸무게를 입력하시오. (kg 단위): ")
    var w = readLine()!!.toInt();

    var BMI = w / ((h/100.0)*(h/100.0))

    var result = when (BMI){ // 이상~미만을 쓰고 싶을 경우 if 문을 사용해야한다. 지원x
        in 0.0..18.4 -> "저체중"
        in 18.5..22.9 -> "정상"
        in 23.0..24.9 -> "과체중"
        else -> "비만"

    }
    println("키 $h cm, 몸무게 $w kg의 BMI 지수는 $result 이며 ${BMI} 입니다.")
}