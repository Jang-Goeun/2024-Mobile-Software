package ddwu.mobile.week02.kotlintest
import java.util.Random    // Alt + Enter 누르면 클래스 자동 클래스 포함 가능
// 1~45까지의 수 중 서로 다른 숫자 6개 생성
fun main(){
    val lotto = mutableSetOf<Int>() // val인 이유 -> lotto가 가리키는 위치가 변하지 않음 var일 경우 위치가 바뀔 수 있음!!
    val random = Random(); // random은 여번 만들 필요가 없으므로 while문 밖에서 사용할 것

    while(lotto.size != 6){
        var num = random.nextInt(45) + 1 //  -> 0~44 사이의 랜덤한 값을 만들어 내는 것으로 1을 더해줘야 함
        lotto.add(num)
    }

    print("로또 번호: ")
    for (lot in lotto) {
        print("$lot ")
    }

    // println("로또 번호: $lotto")
}