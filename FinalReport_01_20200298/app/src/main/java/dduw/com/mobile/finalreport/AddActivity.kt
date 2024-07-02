package dduw.com.mobile.finalreport

import android.content.ContentValues
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dduw.com.mobile.finalreport.data.DiaryDBHelper
import dduw.com.mobile.finalreport.data.DiaryDao
import dduw.com.mobile.finalreport.data.DiaryDto
import dduw.com.mobile.finalreport.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    val addBinding by lazy {
        ActivityAddBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(addBinding.root)

        //추가 버튼
        addBinding.addBtn.setOnClickListener{
            if (addBinding.editTitle.text.toString().equals("")){      //제목 필수 입력 항목
                Toast.makeText(this@AddActivity, "제목을 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                val title = addBinding.editTitle.text.toString()
                var date = addBinding.editDate.text.toString()
                val weather = addBinding.editWeather.text.toString()
                val location = addBinding.editLocation.text.toString()
                val content = addBinding.editContent.text.toString()
                val newDto = DiaryDto(0, date, weather, title, content, location)

                if (addNewDiary(newDto) > 0) {
                    Toast.makeText(this@AddActivity, "추가되었습니다.", Toast.LENGTH_SHORT).show()
                    setResult(RESULT_OK)
                } else {
                    setResult(RESULT_CANCELED)
                }

                finish()
            }
        }

        //취소 버튼
        addBinding.canBtn.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }

    }
    fun addNewDiary(newDto : DiaryDto) : Long  {
        val helper = DiaryDBHelper(this)
        val db = helper.writableDatabase

        val newValues = ContentValues()
        newValues.put(DiaryDBHelper.COL_TITLE, newDto.title)
        newValues.put(DiaryDBHelper.COL_DATE, newDto.day)
        newValues.put(DiaryDBHelper.COL_WEATHER, newDto.weather)
        newValues.put(DiaryDBHelper.COL_CONTENT, newDto.content)
        newValues.put(DiaryDBHelper.COL_LOCATION, newDto.location)

        val result = db.insert(DiaryDBHelper.TABLE_NAME, null, newValues)

        helper.close()
        return result
    }
}