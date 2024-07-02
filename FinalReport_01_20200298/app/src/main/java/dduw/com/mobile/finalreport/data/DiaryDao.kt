package dduw.com.mobile.finalreport.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns

class DiaryDao(val context: Context) {
    @SuppressLint("Range")
    fun getAllDiarys() : ArrayList<DiaryDto> {
        val helper = DiaryDBHelper(context)
        val db = helper.readableDatabase
        val cursor = db.query(DiaryDBHelper.TABLE_NAME, null, null, null, null, null, null)

        val diarys = arrayListOf<DiaryDto>()

        with (cursor) {
            while (moveToNext()) {
                val id = getInt( getColumnIndex(BaseColumns._ID) )
                val title = getString ( getColumnIndex(DiaryDBHelper.COL_TITLE) )
                val date = getString ( getColumnIndex(DiaryDBHelper.COL_DATE) )
                val weather = getString ( getColumnIndex(DiaryDBHelper.COL_WEATHER) )
                val location = getString ( getColumnIndex(DiaryDBHelper.COL_LOCATION) )
                val content = getString ( getColumnIndex(DiaryDBHelper.COL_CONTENT) )
                val dto = DiaryDto(id, date, weather, title, content, location)
                diarys.add(dto)
            }
        }

        cursor.close()
        helper.close()

        return diarys
    }

}