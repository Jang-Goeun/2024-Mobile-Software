package dduw.com.mobile.finalreport.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class DiaryDBHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
    val TAG = "DiaryDBHelper"
    companion object{
        const val DB_NAME = "diary_db"
        const val TABLE_NAME = "diary_table"
        const val COL_DATE = "day"
        const val COL_WEATHER = "weather"
        const val COL_TITLE = "title"
        const val COL_CONTENT = "content"
        const val COL_LOCATION = "location"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_DATE TEXT, $COL_WEATHER TEXT, $COL_TITLE TEXT, $COL_CONTENT TEXT, $COL_LOCATION TEXT)"
        Log.d(TAG, CREATE_TABLE)
        db?.execSQL(CREATE_TABLE)

        // 샘플 데이터 5개 추가
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, '2024.01.01', '추움', '벌써 24살이다!!', '대학온지 얼마 안된 거 같은데...', '집')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, '2024.03.02', '맑음', '벌써 개강이라니..', '개강이라니..이건 꿈이야..', '동덕여자대학교')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, '2024.04.02', '맑음', '생일이 제일 바쁘다 바빠', '눈감았다 뜨면 생일이 끝나겠다..ㅜ', '동덕여자대학교, 집')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, '2024.05.05', '더움', '어린이날', '나도 아직 마음만은 어린이야!', '집')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, '2024.06.25', '더움', '종강이다!!', '드디어 종강이야 종강..ㅠㅠㅠ', '집')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }
}