package dduw.com.mobile.finalreport.data

class SimpleDiaryDao {
    private val diaryList = ArrayList<DiaryDto>()
    init{
        diaryList.add(DiaryDto(1, "2024.01.01", "추움", "벌써 24살이다!!", "대학온지 얼마 안된 거 같은데...", "집"))
        diaryList.add(DiaryDto(2, "2024.03.02", "맑음", "벌써 개강이라니..", "개강이라니..이건 꿈이야..", "동덕여자대학교"))
        diaryList.add(DiaryDto(3, "2024.04.02", "맑음", "생일이 제일 바쁘다 바빠", "눈감았다 뜨면 생일이 끝나겠다..ㅜ", "동덕여자대학교, 집"))
        diaryList.add(DiaryDto(4, "2024.05.05", "더움", "어린이날", "나도 아직 마음만은 어린이야!", "집"))
        diaryList.add(DiaryDto(5, "2024.06.25", "더움", "종강이다!!", "드디어 종강이야 종강..ㅠㅠㅠ", "집"))
    }

    fun getAllDiarys() : ArrayList<DiaryDto> {

        return diaryList
    }

    fun addNewDiary(newDiaryDto : DiaryDto) {
        diaryList.add(newDiaryDto)
    }

    fun modifyDiary(pos: Int, modifyDiaryDto : DiaryDto) {
        diaryList.set(pos, modifyDiaryDto)
    }

    fun removeDiary(removeDiaryDto : DiaryDto) {
        val index = diaryList.indexOf(removeDiaryDto)
        diaryList.removeAt(index)
    }

    fun getDiaryByPos(pos : Int) = diaryList.get(pos)
}