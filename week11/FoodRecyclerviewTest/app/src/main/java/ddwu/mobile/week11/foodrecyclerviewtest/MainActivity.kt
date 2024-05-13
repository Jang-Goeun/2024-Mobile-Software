package ddwu.mobile.week11.foodrecyclerviewtest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
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
        enableEdgeToEdge()
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
                Toast.makeText(this@MainActivity, "${foods[position]}", Toast.LENGTH_SHORT).show()
                foods.removeAt(position)
                adapter.notifyDataSetChanged()
                return true
            }
        }
        adapter.setOnItemLongClickListener(longClickListener)
    }
}