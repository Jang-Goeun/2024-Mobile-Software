package dduw.com.mobile.finalreport

import android.content.ContentValues
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dduw.com.mobile.finalreport.data.DiaryDBHelper
import dduw.com.mobile.finalreport.data.DiaryDto
import dduw.com.mobile.finalreport.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    val updateBinding by lazy{
        ActivityUpdateBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(updateBinding.root)

        /*RecyclerView 에서 선택하여 전달한 dto 를 확인*/
        val dto = intent.getSerializableExtra("dto") as DiaryDto

        var index = dto.id
        var image = R.mipmap.feel01
        when(index%6){     // 나머지에 따라 임의의 이미지 배정
            0 -> image = R.mipmap.feel01
            1 -> image = R.mipmap.feel02
            2 -> image = R.mipmap.feel03
            3 -> image = R.mipmap.feel04
            4 -> image = R.mipmap.feel05
            5 -> image = R.mipmap.feel06
        }
        updateBinding.updatePhoto.setImageResource( image)
        updateBinding.updateDate.setText(dto.day)
        updateBinding.updateWeather.setText(dto.weather)
        updateBinding.updateTitle.setText(dto.title)
        updateBinding.updateContent.setText(dto.content)
        updateBinding.updateLocation.setText(dto.location)

        updateBinding.updateBtn.setOnClickListener{

            if (updateBinding.updateTitle.text.toString().equals("")){      // 제목 필수 입력 확인
                Toast.makeText(this@UpdateActivity, "제목을 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                dto.title = updateBinding.updateTitle.text.toString()
                dto.day = updateBinding.updateDate.text.toString()
                dto.weather = updateBinding.updateWeather.text.toString()
                dto.location = updateBinding.updateLocation.text.toString()
                dto.content = updateBinding.updateContent.text.toString()

                if (updateDiary(dto) > 0) {
                    setResult(RESULT_OK)
                } else {
                    setResult(RESULT_CANCELED)
                }
                finish()
            }
        }

        updateBinding.cancelBtn.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }
    }
    /*update 정보를 담고 있는 dto 를 전달 받아 dto 의 id 를 기준으로 수정*/
    fun updateDiary(dto: DiaryDto): Int {
        val helper = DiaryDBHelper(this)
        val db = helper.writableDatabase
        val updateValue = ContentValues()

        updateValue.put(DiaryDBHelper.COL_DATE, dto.day)
        updateValue.put(DiaryDBHelper.COL_WEATHER, dto.weather)
        updateValue.put(DiaryDBHelper.COL_TITLE, dto.title)
        updateValue.put(DiaryDBHelper.COL_CONTENT, dto.content)
        updateValue.put(DiaryDBHelper.COL_LOCATION, dto.location)
        val whereCaluse = "${BaseColumns._ID}=?"
        val whereArgs = arrayOf(dto.id.toString())

        val result =  db.update(DiaryDBHelper.TABLE_NAME, updateValue, whereCaluse, whereArgs)
        helper.close()
        return result
    }
}