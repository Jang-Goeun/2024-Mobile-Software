package ddwu.mobile.week10.recyclerviewtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.mobile.week10.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val dao = SubjectDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //  1-2.만들어 놓은 원본 데이터 가져오기
        val dataList = dao.dataList

        // 5. RecyclerView 표시
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL  // 생략가능
        binding.recyclerView.layoutManager = layoutManager

        // adapter 결합
        val adapter = MyAdapter(this, R.layout.list_item, dataList)
        binding.recyclerView.adapter = adapter

        binding.button.setOnClickListener{
            dataList.add(binding.etSubject.text.toString())
            adapter.notifyDataSetChanged()
        }

    }
}