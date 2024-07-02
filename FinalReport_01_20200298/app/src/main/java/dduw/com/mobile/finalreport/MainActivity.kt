//과제명:다이어리 앱 - 하루의 일과를 기록
//분반: 01분반
//학번: 20200298 성명: 장고은
//제출일: 2024년 6월 21일

package dduw.com.mobile.finalreport

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.BaseColumns
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dduw.com.mobile.finalreport.data.DiaryDBHelper
import dduw.com.mobile.finalreport.data.DiaryDao
import dduw.com.mobile.finalreport.data.DiaryDto
import dduw.com.mobile.finalreport.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val dao: DiaryDao by lazy {
        DiaryDao(this)
    }

    val REQ_ADD = 100
    val REQ_UPDATE = 200
    lateinit var diarys : ArrayList<DiaryDto>
    lateinit var adapter : DiaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        diarys = dao.getAllDiarys()

        adapter = DiaryAdapter(diarys)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        mainBinding.rvDiary.layoutManager = layoutManager
        mainBinding.rvDiary.adapter = adapter

        // 클릭 시
        val onClickListener = object : DiaryAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, UpdateActivity::class.java)
                intent.putExtra("dto", diarys.get(position) )
                startActivityForResult(intent, REQ_UPDATE)
            }
        }
        adapter.setOnItemClickListener(onClickListener)

        // 롱클릭 시
        val onLongClickListener = object: DiaryAdapter.OnItemLongClickListener {
            override fun onItemLongClick(view: View, position: Int) {
                AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("다이어리 삭제")
                    setMessage("해당 다이어리를 삭제하시겠습니까?(제목:${diarys[position].title})")
                    setPositiveButton("삭제", object : DialogInterface.OnClickListener{
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            if ( deleteDiary(diarys.get(position)) > 0) {
                                diarys.clear()
                                diarys.addAll(dao.getAllDiarys())
                                mainBinding.rvDiary.adapter?.notifyDataSetChanged()
                            }
                        }
                    })
                    setNegativeButton("취소", null)
                    show()
                }
            }
        }
        adapter.setOnItemLongClickListener(onLongClickListener)
    }

    override fun onResume() {
        super.onResume()
        mainBinding.rvDiary.adapter?.notifyDataSetChanged()   // 액티비티가 보일 때마다 RecyclerView 를 갱신하고자 할 경우
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQ_UPDATE -> {
                if (resultCode == RESULT_OK) {
                    diarys.clear()                       // 기존 항목 제거
                    diarys.addAll(dao.getAllDiarys())         // 항목 추가
                } else {
                    Toast.makeText(this@MainActivity, "취소됨", Toast.LENGTH_SHORT).show()
                }
            }
            REQ_ADD -> {
                if (resultCode == RESULT_OK) {
                    diarys.clear()                       // 기존 항목 제거
                    diarys.addAll(dao.getAllDiarys())         // 항목 추가
                } else {
                    Toast.makeText(this@MainActivity, "취소됨", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    /*레코드 삭제 후 삭제된 레코드 개수 반환*/
    fun deleteDiary(dto: DiaryDto) : Int {
        val helper = DiaryDBHelper(this)
        val db = helper.writableDatabase

        val whereClause = "${BaseColumns._ID}=?"
        val whereArgs = arrayOf(dto.id.toString())
        val result = db.delete(DiaryDBHelper.TABLE_NAME, whereClause, whereArgs)

        helper.close()
        return result
    }

    // 옵션 메뉴 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 옵션 메뉴 선택
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_id -> {  // 다이어리 추가
                val intent = Intent(this, AddActivity::class.java)
                startActivityForResult(intent, REQ_ADD)
            }
            R.id.dev_id -> {  // 개발자 소개
                val intent = Intent(this@MainActivity, DevActivity::class.java)
                startActivity(intent)
            }
            R.id.exit_id -> {  // 앱 종료
                AlertDialog.Builder(this).apply {
                    setTitle("앱 종료")
                    setMessage("앱을 종료하시겠습니까?")
                    setPositiveButton("종료", object : DialogInterface.OnClickListener{
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            finish()
                        }
                    })
                    setNegativeButton("취소", null)
                    show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}