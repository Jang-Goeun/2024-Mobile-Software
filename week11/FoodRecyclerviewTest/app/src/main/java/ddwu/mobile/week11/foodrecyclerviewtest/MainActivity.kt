package ddwu.mobile.week11.foodrecyclerviewtest

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.mobile.week11.foodrecyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*데이터 준비*/
        val foods = FoodDao().foods

        /*어댑터 생성*/
        val adapter = FoodAdapter(foods)

        /*레이아웃 매니저 생성 및 설정*/
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        /*RecyclerView 에 레이아웃 매니저 및 Adapter 설정*/
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

//        val listener = object : FoodAdapter.OnItemClickListener {
//            override fun onItemClick(view: View, position: Int) {
//                Toast.makeText(this@MainActivity, "${foods[position]}", Toast.LENGTH_SHORT).show()
//                foods.removeAt(position)
//                adapter.notifyDataSetChanged()
//            }
//        }
//        adapter.setOnItemClickListner(listener)

        val longClickListener = object : FoodAdapter.OnItemLongClickListener {
            override fun onItemLongClick(view: View, position: Int) : Boolean {

                val builder:AlertDialog.Builder = AlertDialog.Builder(this@MainActivity).apply {
                    setMessage("${foods[position]}을 삭제하시겠습니까?")
                    setPositiveButton("확인") { dialogInterface: DialogInterface?, i: Int ->
                        foods.removeAt(position)
                        adapter.notifyDataSetChanged()
                    }
                    setNegativeButton("취소", null)
                }  // 롱클릭시 삭제할지 묻는 다이얼로그 생성
                builder.show()
                //Toast.makeText(this@MainActivity, "${foods[position]}", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        adapter.setOnItemLongClickListener(longClickListener)
    }
}